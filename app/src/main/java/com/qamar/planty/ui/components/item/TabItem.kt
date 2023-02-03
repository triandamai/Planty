package com.qamar.planty.ui.components.item

import androidx.compose.animation.animateColorAsState
import androidx.compose.material.Text
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.zIndex
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.qamar.planty.data.model.Plant
import com.qamar.planty.ui.theme.Gray
import com.qamar.planty.ui.theme.textFont

@OptIn(ExperimentalPagerApi::class)
@Composable
 fun TabItem(
    pagerState: PagerState,
    index: Int,
    plant: Plant
) {
    val isSelected = pagerState.currentPage == index
    val color: Color by animateColorAsState(
        if (isSelected) Color.White else Gray
    )
    Tab(
        modifier = Modifier.zIndex(6f),
        text = {
            Text(
                text = plant.name ?: "", color = color,
                style = textFont
            )
        },
        selected = isSelected,
        onClick = { /* TODO */ },
    )
}