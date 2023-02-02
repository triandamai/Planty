package com.qamar.planty.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qamar.planty.data.model.Properties
import com.qamar.planty.ui.theme.LightGray
import com.qamar.planty.ui.theme.percentFont
import com.qamar.planty.ui.theme.textFont


@Composable
fun CircularProgress(property: Properties) {
    val animatedProgress by animateFloatAsState(
        targetValue = property.percent,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    Box {
        CircularProgressIndicator(
            progress = 1f,
            color = LightGray,
            strokeWidth = 1.4.dp,
            modifier = Modifier.size(120.dp)

        )
        CircularProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(14.dp)),
            color = Color.Black,
            strokeWidth = 2.8.dp
        )

        PercentText( property, Modifier.Companion.align(Alignment.Center))
    }

}

@Composable
private fun PercentText(property: Properties, modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "${property.percent.times(100).toInt()}%",
            style = percentFont,
            color = Color.Black
        )
        Text(
            text = property.propertyName,
            style = textFont,
            color = Color.Gray,
        )

    }
}


@Preview
@Composable
fun CircularProgressPreview() {
    CircularProgress(property = Properties(""))
}