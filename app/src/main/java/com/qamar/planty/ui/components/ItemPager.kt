package com.qamar.planty.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.qamar.planty.R
import com.qamar.planty.data.model.Plant
import com.qamar.planty.ui.components.plant.PlantImage
import com.qamar.planty.ui.components.plant.PlantProperty


@Composable
@OptIn(ExperimentalPagerApi::class)
 fun ItemPager(
    pagerState: PagerState,
    pages: List<Plant>
) {
    var currentItem by remember {
        mutableStateOf(Plant(image = R.drawable.plant1))
    }

    LaunchedEffect(pagerState) {
        // get current page
        snapshotFlow { pagerState.currentPage }.collect { page ->
            currentItem = pages[page]
        }
    }
    HorizontalPager(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        count = pages.size,
        state = pagerState,
    ) { page ->
        Box(
            Modifier
                .padding(top = 50.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            PlantImage(
                currentItem,
                Modifier
                    .padding(bottom = 80.dp)
                    .align(Alignment.CenterStart)
            )
            PlantProperty(
                currentItem, Modifier
                    .padding(
                        end = 26.dp,
                        bottom = 50.dp
                    )
                    .align(Alignment.CenterEnd)
                    .wrapContentWidth()
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun ItemPagerPreview(){
    val pagerState = rememberPagerState()
    val pages = Plant(image = R.drawable.plant1).getPlantList()

    ItemPager(pagerState, pages = pages)
}