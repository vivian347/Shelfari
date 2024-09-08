package com.example.shelfari.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.rounded.AlternateEmail
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.shelfari.R

@Composable
fun EmailOutlinedTextFieldComponent(
    labelValue: String,
    textValue: String,
    onValueChange:(String) -> Unit
){
    TextField(
        value = textValue,
        onValueChange = onValueChange,
        label = {
            Row {

                Text(text = labelValue)
            }
                },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.AlternateEmail,
                contentDescription = "Email",
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(24.dp))

        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.primary,
            unfocusedTextColor = Color.DarkGray,
            focusedTextColor = Color.Black
        ),
    )
}

@Composable
fun TextFieldComponent(
    labelValue: String,
    textValue: String,
    onValueChange:(String) -> Unit
){
    TextField(
        value = textValue,
        onValueChange = onValueChange,
        label = {
            Row {
                Text(text = labelValue)
            }
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.EmojiEmotions,
//                painter = painterResource(id = R.drawable.smiley),
                contentDescription = "Name",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(24.dp))

        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.primary,
            unfocusedTextColor = Color.DarkGray,
            focusedTextColor = Color.Black
        ),
    )
}

@Composable
fun PasswordFieldComponent(
    labelValue: String,
    password: String,
    onValueChange:(String) -> Unit
){
    val passwordVisible = remember {
        mutableStateOf(false)
    }

    TextField(
        value = password,
        onValueChange = onValueChange,
        label = {
            Row {
                Text(
                    text = labelValue
                )
            }
                },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Lock,
                contentDescription = "Password",
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(24.dp))

        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
            unfocusedTextColor = Color.DarkGray,
            focusedTextColor = Color.Black
        ),
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Default.Visibility
            } else Icons.Filled.VisibilityOff

            val description = if (passwordVisible.value) {
                "Hide password"
            } else "Show password"

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description, tint = MaterialTheme.colorScheme.primary)
            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else
            PasswordVisualTransformation()
    )
}
