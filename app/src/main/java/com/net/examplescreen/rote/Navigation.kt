package com.net.examplescreen.rote

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.net.examplescreen.ui.screen.PhoneNumberData
import com.net.examplescreen.ui.screen.ScreenOne
import com.net.examplescreen.ui.screen.ScreenTwo

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenA) {

        composable<ScreenA> {
            ScreenOne(navController)
        }

        composable<ScreenB> {
            ScreenTwo(navController, PhoneNumberData())
        }
    }
}