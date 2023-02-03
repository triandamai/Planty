package com.qamar.planty.ui.components.plant

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.qamar.planty.data.model.Plant

@Composable
 fun PlantImage(currentItem: Plant, modifier: Modifier) {
    Crossfade(
        targetState = currentItem,
        modifier = modifier,
        animationSpec = tween(700)
    ) {
        Image(painter = painterResource(id = it.image!!),
              contentDescription = "",)
    }
}