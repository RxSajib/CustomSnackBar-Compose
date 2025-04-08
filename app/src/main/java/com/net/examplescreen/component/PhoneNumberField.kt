package com.net.examplescreen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.net.examplescreen.R
import kotlin.text.isNotEmpty

@Composable
fun PhoneNumberField(
    onValueChange: (String) -> Unit,
    number:String = "",
    maxNumber : Int = 10
) {
    var phoneNumber by remember { mutableStateOf(number) }

    Column {
        Text(
            text = "Phone Number",
            style = MaterialTheme.typography.bodySmall,
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        OutlinedTextField(
            value = phoneNumber,

            onValueChange = {
                if(it.length <= maxNumber){
                    phoneNumber = it
                    onValueChange("+91$it")
                }
            },
            placeholder = {
                Text(
                    text = "9748000000", style = MaterialTheme.typography.bodySmall.copy(
                        color = colorResource(R.color.textSubtitle)
                    )
                )
            },
            leadingIcon = {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = "+91", style = MaterialTheme.typography.bodyMedium
                    )

                    VerticalDivider(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .height(16.dp),
                        thickness = 1.dp,
                        color = colorResource(R.color.border_color)
                    )
                }
            },
            trailingIcon = {
                if (phoneNumber.isNotEmpty()) {
                    IconButton(onClick = {
                        phoneNumber = ""
                        onValueChange("")
                    }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear phone number",
                            tint = colorResource(R.color.textSubtitle)
                        )
                    }
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                unfocusedTextColor = MaterialTheme.colorScheme.primary,
                focusedContainerColor = Color.White,
                focusedTextColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(6.dp), // Rounded corners
            textStyle = MaterialTheme.typography.bodyMedium,
            singleLine = true,

        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {

    var onvalue by remember { mutableStateOf("") }

    PhoneNumberField(
        onValueChange = {
            onvalue = it
        },
        number = "01771330378"
    )
}
