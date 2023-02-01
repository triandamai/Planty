package com.qamar.planty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    }
}


@Preview
@Composable
fun HomeContentPreview() = PlantyTheme {
    HomeContent()
}
