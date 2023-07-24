@file:OptIn(ExperimentalFoundationApi::class)
@file:Suppress("unused")

package com.chichi289.composepager.ui.transformations

/*
* Copyright 2022 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.util.lerp
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.pow

fun Modifier.pagerCubeInDepthTransition(page: Int, pagerState: PagerState) = graphicsLayer {
    cameraDistance = 32f
    // Calculate the absolute offset for the current page from the
    // scroll position.
    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)

    if (pageOffset < -1f) {
        // page is far off screen
        alpha = 0f
    } else if (pageOffset <= 0) {
        // page is to the right of the selected page or the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(0f, 0.5f)
        rotationY = -90f * pageOffset.absoluteValue

    } else if (pageOffset <= 1) {
        // page is to the left of the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(1f, 0.5f)
        rotationY = 90f * pageOffset.absoluteValue
    } else {
        alpha = 0f
    }

    if (pageOffset.absoluteValue <= 0.5) {
        scaleY = 0.4f.coerceAtLeast(1 - pageOffset.absoluteValue)
    } else if (pageOffset.absoluteValue <= 1) {
        scaleY = 0.4f.coerceAtLeast(1 - pageOffset.absoluteValue)
    }
}

fun Modifier.pagerCubeInRotationTransition(page: Int, pagerState: PagerState) = graphicsLayer {
    cameraDistance = 32f
    // Calculate the absolute offset for the current page from the
    // scroll position.
    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)

    if (pageOffset < -1f) {
        // page is far off screen
        alpha = 0f
    } else if (pageOffset <= 0) {
        // page is to the right of the selected page or the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(0f, 0.5f)
        rotationY = -90f * pageOffset.absoluteValue

    } else if (pageOffset <= 1) {
        // page is to the left of the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(1f, 0.5f)
        rotationY = 90f * pageOffset.absoluteValue
    } else {
        alpha = 0f
    }
}

fun Modifier.pagerCubeInScalingTransition(page: Int, pagerState: PagerState) = graphicsLayer {
    cameraDistance = 32f
    // Calculate the absolute offset for the current page from the
    // scroll position.
    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)

    if (pageOffset < -1f) {
        // page is far off screen
        alpha = 0f
    } else if (pageOffset <= 0) {
        // page is to the right of the selected page or the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(0f, 0.5f)
        rotationY = -90f * pageOffset.absoluteValue

    } else if (pageOffset <= 1) {
        // page is to the left of the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(1f, 0.5f)
        rotationY = 90f * pageOffset.absoluteValue
    } else {
        alpha = 0f
    }

    if (pageOffset.absoluteValue <= 0.5) {
        scaleY = .4f.coerceAtLeast(1 - pageOffset.absoluteValue)
        scaleX = .4f.coerceAtLeast(1 - pageOffset.absoluteValue)
    } else if (pageOffset.absoluteValue <= 1) {
        scaleY = .4f.coerceAtLeast(pageOffset.absoluteValue)
        scaleX = .4f.coerceAtLeast(pageOffset.absoluteValue)
    }
}

fun Modifier.pagerCubeOutDepthTransition(page: Int, pagerState: PagerState) = graphicsLayer {
    // Calculate the absolute offset for the current page from the
    // scroll position.
    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)
    if (pageOffset < -1f) {
        // page is far off screen
        alpha = 0f
    } else if (pageOffset <= 0) {
        // page is to the right of the selected page or the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(0f, 0.5f)
        rotationY = 90f * pageOffset.absoluteValue
    } else if (pageOffset <= 1) {
        // page is to the left of the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(1f, 0.5f)
        rotationY = -90f * pageOffset.absoluteValue
    } else {
        alpha = 0f
    }

    if (pageOffset.absoluteValue <= 0.5) {
        scaleY = 0.4f.coerceAtLeast(1 - pageOffset.absoluteValue)
    } else if (pageOffset.absoluteValue <= 1) {
        scaleY = 0.4f.coerceAtLeast(1 - pageOffset.absoluteValue)
    }
}

fun Modifier.pagerCubeOutRotationTransition(page: Int, pagerState: PagerState) = graphicsLayer {
    // Calculate the absolute offset for the current page from the
    // scroll position.
    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)
    if (pageOffset < -1f) {
        // page is far off screen
        alpha = 0f
    } else if (pageOffset <= 0) {
        // page is to the right of the selected page or the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(0f, 0.5f)
        rotationY = 90f * pageOffset.absoluteValue

    } else if (pageOffset <= 1) {
        // page is to the left of the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(1f, 0.5f)
        rotationY = -90f * pageOffset.absoluteValue
    } else {
        alpha = 0f
    }
}

fun Modifier.pagerFadeOutTransition(page: Int, pagerState: PagerState) = graphicsLayer {
    // Calculate the absolute offset for the current page from the
    // scroll position. We use the absolute value which allows us to mirror
    // any effects for both directions
    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)

    alpha = lerp(
        start = 0.5f,
        stop = 1f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    translationX = (-page * size.width)
}

fun Modifier.pagerCubeOutScalingTransition(page: Int, pagerState: PagerState) = graphicsLayer {
    // Calculate the absolute offset for the current page from the
    // scroll position.
    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)
    if (pageOffset < -1f) {
        // page is far off screen
        alpha = 0f
    } else if (pageOffset <= 0) {
        // page is to the right of the selected page or the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(0f, 0.5f)
        rotationY = 90f * pageOffset.absoluteValue

    } else if (pageOffset <= 1) {
        // page is to the left of the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(1f, 0.5f)
        rotationY = -90f * pageOffset.absoluteValue
    } else {
        alpha = 0f
    }

    if (pageOffset.absoluteValue <= 0.5) {
        scaleY = 0.4f.coerceAtLeast(1 - pageOffset.absoluteValue)
        scaleX = 0.4f.coerceAtLeast(1 - pageOffset.absoluteValue)
    } else if (pageOffset.absoluteValue <= 1) {
        scaleY = 0.4f.coerceAtLeast(pageOffset.absoluteValue)
        scaleX = 0.4f.coerceAtLeast(pageOffset.absoluteValue)
    }
}

fun Modifier.pagerDepthTransition(page: Int, pagerState: PagerState) = graphicsLayer {
    // Calculate the absolute offset for the current page from the
    // scroll position.
    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)

    if (pageOffset < -1f) {
        // page is far off screen
        alpha = 0f
    } else if (pageOffset <= 0) {
        // page is to the right of the selected page or the selected page

        translationX = pageOffset * size.width
        // alpha = 1- abs(pageOffset)
        scaleX = 1 - abs(pageOffset)
        scaleY = 1 - abs(pageOffset)
    } else if (pageOffset <= 1) {
        // page is to the left of the selected page
        alpha = 1f
        scaleX = 1f
        scaleY = 1f
        translationX = 0f

    } else {
        alpha = 0f
    }
    // TODO zIndex not supported yet in Pager b/265931282
}/*.zIndex(-page.toFloat())*/

fun Modifier.pagerFadeTransition(page: Int, pagerState: PagerState) =
    graphicsLayer {
        val pageOffset = pagerState.calculateCurrentOffsetForPage(page)
        // translate the contents by the size of the page, to prevent the pages from sliding
        // in from left or right and stays in the center
        translationX = pageOffset * size.width

        // apply an alpha to fade the current page in and the old page out
        alpha = 1 - pageOffset.absoluteValue
    }

fun Modifier.pagerFanTransition(page: Int, pagerState: PagerState) = graphicsLayer {
    cameraDistance = 2000f
    // Calculate the absolute offset for the current page from the
    // scroll position.
    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)
    translationX = pageOffset * size.width
    transformOrigin = TransformOrigin(0f, 0.5f)

    if (pageOffset < -1f) {
        // page is far off screen
        alpha = 0f
    } else if (pageOffset <= 0) {
        // page is to the right of the selected page or the selected page
        alpha = 1f
        rotationY = -120f * pageOffset.absoluteValue

    } else if (pageOffset <= 1) {
        // page is to the left of the selected page
        alpha = 1f
        rotationY = 120f * pageOffset.absoluteValue
    } else {
        alpha = 0f
    }
}

fun Modifier.pagerFidgetSpinTransition(page: Int, pagerState: PagerState) = graphicsLayer {
    // Calculate the absolute offset for the current page from the
    // scroll position.
    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)
    translationX = pageOffset * size.width

    if (pageOffset < -1f) {
        // page is far off screen
        alpha = 0f
    } else if (pageOffset <= 0) {
        // page is to the right of the selected page or the selected page
        alpha = 1f
        rotationZ = -36000f * pageOffset.absoluteValue.pow(7)

    } else if (pageOffset <= 1) {
        // page is to the left of the selected page
        alpha = 1f
        rotationZ = 36000f * pageOffset.absoluteValue.pow(7)
    } else {
        alpha = 0f
    }

    if (pageOffset.absoluteValue <= 0.5) {
        alpha = 1f
        scaleX = (1 - pageOffset.absoluteValue)
        scaleY = (1 - pageOffset.absoluteValue)
    } else if (pageOffset.absoluteValue > 0.5) {
        alpha = 0f
    }

}

@OptIn(ExperimentalFoundationApi::class)
fun Modifier.pagerGateTransition(page: Int, pagerState: PagerState) = graphicsLayer {
    // Calculate the absolute offset for the current page from the
    // scroll position.
    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)
    translationX = pageOffset * size.width

    if (pageOffset < -1f) {
        // page is far off screen
        alpha = 0f
    } else if (pageOffset <= 0) {
        // page is to the right of the selected page or the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(1f, 0.5f)
        rotationY = -90f * pageOffset.absoluteValue

    } else if (pageOffset <= 1) {
        // page is to the left of the selected page
        alpha = 1f
        transformOrigin = TransformOrigin(0f, 0.5f)
        rotationY = 90f * pageOffset.absoluteValue
    } else {
        alpha = 0f
    }
}

fun Modifier.pagerHingeTransition(page: Int, pagerState: PagerState) = graphicsLayer {
    // Calculate the absolute offset for the current page from the
    // scroll position.
    val pageOffset = pagerState.calculateCurrentOffsetForPage(page)
    translationX = pageOffset * size.width
    transformOrigin = TransformOrigin(0f, 0f)

    if (pageOffset < -1f) {
        // page is far off screen
        alpha = 0f
    } else if (pageOffset <= 0) {
        // page is to the right of the selected page or the selected page
        alpha = 1f - pageOffset.absoluteValue
        rotationZ = 0f

    } else if (pageOffset <= 1) {
        // page is to the left of the selected page
        alpha = 1f - pageOffset.absoluteValue
        rotationZ = 90f * pageOffset.absoluteValue
    } else {
        alpha = 0f
    }
}

fun Modifier.pagerSpinningClockwiseTransition(page: Int, pagerState: PagerState): Modifier {
    return this.then(graphicsLayer {
        // Calculate the absolute offset for the current page from the
        // scroll position.
        val pageOffset = ((pagerState.currentPage - page) + pagerState
            .currentPageOffsetFraction)
        translationX = pageOffset * size.width

        if (pageOffset < -1f) {
            // page is far off screen
            alpha = 0f
        } else if (pageOffset <= 0) {
            // page is to the right of the selected page or the selected page
            alpha = 1f
            rotationZ = -360f * pageOffset.absoluteValue

        } else if (pageOffset <= 1) {
            // page is to the left of the selected page
            alpha = 1f
            rotationZ = 360f * pageOffset.absoluteValue
        } else {
            alpha = 0f
        }

        if (pageOffset.absoluteValue <= 0.5) {
            alpha = 1f
            scaleX = (1 - pageOffset.absoluteValue)
            scaleY = (1 - pageOffset.absoluteValue)
        } else if (pageOffset.absoluteValue > 0.5) {
            alpha = 0f
        }

    })
}

fun Modifier.pagerSpinningAntiClockwiseTransition(page: Int, pagerState: PagerState) =
    graphicsLayer {
        // Calculate the absolute offset for the current page from the
        // scroll position.
        val pageOffset = pagerState.calculateCurrentOffsetForPage(page)
        translationX = pageOffset * size.width

        if (pageOffset < -1f) {
            // page is far off screen
            alpha = 0f
        } else if (pageOffset <= 0) {
            // page is to the right of the selected page or the selected page
            alpha = 1f
            rotationZ = 360f * pageOffset.absoluteValue

        } else if (pageOffset <= 1) {
            // page is to the left of the selected page
            alpha = 1f
            rotationZ = -360f * pageOffset.absoluteValue
        } else {
            alpha = 0f
        }

        if (pageOffset.absoluteValue <= 0.5) {
            alpha = 1f
            scaleX = (1 - pageOffset.absoluteValue)
            scaleY = (1 - pageOffset.absoluteValue)
        } else if (pageOffset.absoluteValue > 0.5) {
            alpha = 0f
        }

    }

fun PagerState.calculateCurrentOffsetForPage(page: Int): Float {
    return (currentPage - page) + currentPageOffsetFraction
}