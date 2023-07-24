@file:OptIn(ExperimentalFoundationApi::class)

package com.chichi289.composepager.ui.pagers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.chichi289.composepager.ui.transformations.pagerGateTransition
import com.chichi289.composepager.ui.utils.rememberRandomSampleImageUrl

@Composable
fun TransformationPagerDemo() {
    val pagerState = rememberPagerState()

    HorizontalPager(
        pageCount = 10,
        modifier = Modifier.fillMaxSize(),
        state = pagerState
    ) { page ->
        Box(
            modifier = Modifier.pagerGateTransition(page, pagerState)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = rememberRandomSampleImageUrl(width = 1200)
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp)),
            )
        }
    }
}