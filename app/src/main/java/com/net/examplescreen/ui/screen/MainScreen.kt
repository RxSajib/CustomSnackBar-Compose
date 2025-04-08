package com.net.examplescreen.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.net.examplescreen.rote.ScreenA

@Composable
fun MainScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Button(onClick = {
            navHostController.navigate(ScreenA)
        }) {
            Text(
                text = "Home"
            )
        }
    }
}