package com.chichi289.composepager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chichi289.composepager.ui.LandingScreen
import com.chichi289.composepager.ui.pagers.DribbleInspirationPager
import com.chichi289.composepager.ui.pagers.LineIndicatorPager
import com.chichi289.composepager.ui.pagers.TransformationPagerDemo
import com.chichi289.composepager.ui.theme.ComposePagerTheme

// Ref:- https://medium.com/androiddevelopers/customizing-compose-pager-with-fun-indicators-and-transitions-12b3b69af2cc

class MainActivity : ComponentActivity() {

    companion object {
        private const val LANDING_SCREEN = "LandingScreen"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = LANDING_SCREEN
                    ) {
                        composable(LANDING_SCREEN) { LandingScreen(navController) }
                        composable(Common.ScreenName.TransformationPagerDemo.value) { TransformationPagerDemo() }
                        composable(Common.ScreenName.DribbleInspirationPager.value) { DribbleInspirationPager() }
                        composable(Common.ScreenName.LineIndicatorPager.value) { LineIndicatorPager() }
                    }
                }
            }
        }
    }
}