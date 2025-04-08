package com.net.examplescreen.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.net.examplescreen.R
import com.net.examplescreen.component.Event
import com.net.examplescreen.component.MyCustomSnackBar
import com.net.examplescreen.rote.ScreenB

private const val TAG = "ScreenOne"

@Composable
fun ScreenOne(navHostController: NavHostController) {

    val eventFlow = Event.state.collectAsState()

    Log.d(TAG, "ScreenOne: ${eventFlow.value.details}")
    val snackBarState = remember {
        mutableStateOf(false)
    }

    DisposableEffect(Unit) {
        onDispose {
            Event.save(
                details = eventFlow.value.copy(
                    show = false,
                    details = null,
                    title = null
                )
            )
        }
    }

    Surface {
        Scaffold() {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it), contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    navHostController.navigate(ScreenB)
                }) {
                    Text(
                        text = "One"
                    )
                }

                if (eventFlow.value.show) {
                    MyCustomSnackBar(
                        modifier = Modifier.fillMaxSize(),
                        message = eventFlow.value.details ?: "",
                        leftIcon = eventFlow.value.leftIcon ?: R.mipmap.ic_launcher,
                        rightIcon = R.drawable.success_svgrepo_com,
                        onDismiss = {
                            Event.save(
                                details = eventFlow.value.copy(
                                    show = false,
                                    details = null,
                                    title = null
                                )
                            )
                        })
                }

            }
        }
    }
}