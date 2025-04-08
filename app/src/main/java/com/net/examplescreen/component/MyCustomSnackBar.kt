package com.net.examplescreen.component

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.net.examplescreen.R
import kotlinx.coroutines.delay

enum class MySnackbarPosition {
    TOP,
    BOTTOM
}


@Composable
fun MyCustomSnackBar(
    modifier: Modifier = Modifier.fillMaxSize(),
    message: String,
    leftIcon: Int,
    rightIcon: Int? = null,
    position: MySnackbarPosition = MySnackbarPosition.TOP,
    onDismiss: (() -> Unit)? = null
) {



    var visible by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        delay(3000)
        visible = false
        onDismiss?.invoke()
    }
    Box(
        modifier = modifier,
        contentAlignment = when (position) {
            MySnackbarPosition.TOP -> Alignment.TopCenter
            MySnackbarPosition.BOTTOM -> Alignment.BottomCenter
        }
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn() + slideInVertically(
                initialOffsetY = { -it }, // Slide in from top
            ),
            exit = fadeOut() + slideOutVertically(
                targetOffsetY = { -it } // Slide out to top (optional)
            )
        ) {
            CustomSnackBar(message = message, leftIcon = leftIcon, rightIcon = rightIcon)
        }
    }
}

@Composable
fun CustomSnackBar(message : String, leftIcon: Int, rightIcon: Int? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            contentColor = Color.Red,
            containerColor = Color.Red
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = leftIcon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Text(
                text = message,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )
            rightIcon?.let {
                Spacer(
                    modifier = Modifier.width(10.dp)
                )

                Image(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MyCustomSnackBar(modifier = Modifier.fillMaxSize(), message = "Email validation success",
        leftIcon = R.drawable.ic_email, rightIcon = R.drawable.success_svgrepo_com)
}