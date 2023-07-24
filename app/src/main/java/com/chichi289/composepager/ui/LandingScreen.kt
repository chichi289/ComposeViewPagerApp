package com.chichi289.composepager.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.chichi289.composepager.Common

@Composable
fun LandingScreen(navHostController: NavHostController) {
    val screenNames = Common.ScreenName.values()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(screenNames.size) { index ->
            Button(onClick = {
                navHostController.navigate(screenNames[index].value)
            }) {
                Text(text = screenNames[index].value)
            }
        }
    }
}