package com.qamar.planty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.planty.ui.components.CategoryTabs
import com.qamar.planty.ui.theme.PlantyTheme
import com.qamar.planty.ui.theme.titleFont

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlantyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    HomeContent()
                }
            }
        }
    }
}

@Composable
fun HomeContent() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "Planty App", style = titleFont,
            color = Color.Black,
            modifier = Modifier.padding(start = 52.dp, top = 50.dp)
        )
        CategoryTabs()
        Spacer(modifier = Modifier.weight(1f))
        Row(
            Modifier
                .fillMaxWidth()
                .requiredHeight(150.dp)
                .background(Color.Transparent),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(150.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                contentPadding = PaddingValues(0.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "TAKE CARE",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = titleFont,
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth(1f)
                            .height(150.dp),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeContentPreview() = PlantyTheme {
    HomeContent()
}
