package com.net.examplescreen.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.net.examplescreen.component.Details
import com.net.examplescreen.component.Event
import com.net.examplescreen.R
import com.net.examplescreen.component.PhoneNumberField

data class PhoneNumberData(val number : String = "01771330378")

@Composable
fun ScreenTwo(navHostController: NavHostController, phoneNumberData: PhoneNumberData) {

    val vm : ScreenTwoViewModel = hiltViewModel()
    val number = vm.state.collectAsStateWithLifecycle(phoneNumberData.number)

    Surface {
        Scaffold() {
            Box(modifier = Modifier.fillMaxSize().padding(it), contentAlignment = Alignment.Center){

                Column {
                    PhoneNumberField(
                        onValueChange = {
                            vm.saveNumber(it)
                        },
                        number = number.value,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        Event.save(details = Details(details = "Password update success", title = "Title", show = true, leftIcon = R.drawable.ic_email))
                        navHostController.popBackStack()
                    }) {
                        Text(
                            text = "Two"
                        )
                    }
                }

            }
        }
    }
}