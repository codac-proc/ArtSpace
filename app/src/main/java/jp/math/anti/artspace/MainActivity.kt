package jp.math.anti.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jp.math.anti.artspace.ui.theme.ArtSpaceTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpace(
                    name = "Android",
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun ArtSpace(name: String, modifier: Modifier = Modifier) {
    var pageCount by remember { mutableStateOf(0) }
    val imageResource = when(pageCount){
        1 -> R.drawable.design_ai_1
        2 -> R.drawable.design_ai_2
        3 -> R.drawable.design_ai_3
        else -> R.drawable.design_ai_1
    }

    val titleResource = when(pageCount) {
        1 -> R.string.design_1_title
        2 -> R.string.design_2_title
        3 -> R.string.design_3_title
        else -> R.string.design_1_title
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .padding(32.dp)
                .shadow(2.dp)
        ){
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                modifier = Modifier
                    .padding(32.dp)
            )
        }

        Column(
            modifier = Modifier.width(320.dp).height(156.dp).padding(top = 48.dp, bottom = 24.dp).background(Color(0xffecebf4)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = stringResource(titleResource),
                fontWeight = FontWeight.Light,
                fontSize = 32.sp,
                modifier = Modifier
            )
            Row(

            ){
                Text(
                    text = "Codac-proc",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                Text(
                    text = "(2025)",
                    modifier = Modifier
                )
            }

        }

        Row(
            modifier = Modifier.width(320.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = {
                    if(pageCount <= 1){
                        pageCount = 3
                    }else{
                        pageCount--
                    }
                },
                modifier = Modifier.width(128.dp)
            ){
                Text("Previous")
            }
            Button(
                onClick = {
                    if(pageCount >= 3){
                        pageCount = 1
                    }else{
                        pageCount++
                    }
                },
                modifier = Modifier.width(128.dp)
            ){
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace("Android")
    }
}