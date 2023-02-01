package com.qamar.planty.ui.components


import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Tab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.google.accompanist.pager.*
import com.qamar.planty.ui.theme.Gray
import com.qamar.planty.ui.theme.PlantyTheme
import com.qamar.planty.ui.theme.textFont

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CategoryTabs() {
    val pagerState = rememberPagerState()
    val pages = listOf("kotlin", "java", "c#", "php", "golang", "rust")
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    ScrollableTabRow(
        modifier = Modifier
            .padding(top = 33.dp, start = 37.dp)
            .height(30.dp),
        selectedTabIndex = pagerState.currentPage,
        indicator = indicator,
        backgroundColor = Color.White,
        edgePadding = 0.dp,
        divider = {
            Divider(color = Color.Transparent)
        }
    ) {
        pages.forEachIndexed { index, title ->
            val isSelected = pagerState.currentPage == index
            val color: Color by animateColorAsState(
                if (isSelected) Color.White else Gray
            )
            Tab(
                modifier = Modifier.zIndex(6f),
                text = {
                    Text(
                        text = title, color = color,
                        style = textFont
                    )
                },
                selected = isSelected,
                onClick = { /* TODO */ },
            )
        }
    }

    HorizontalPager(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        count = pages.size,
        state = pagerState,
    ) { page ->
        Box(Modifier.fillMaxSize()) {
            Text(modifier = Modifier.align(Alignment.Center), text = "Page $page")
        }
    }


}

@Preview
@Composable
fun CategoryTabsPreview() = PlantyTheme {
    CategoryTabs()
}