package com.example.shelfari.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shelfari.R
import com.example.shelfari.presentation.components.EmailOutlinedTextFieldComponent
import com.example.shelfari.presentation.components.PasswordFieldComponent
import com.example.shelfari.presentation.components.TextFieldComponent
import com.example.shelfari.ui.theme.ShelfariTheme

@Composable
fun SignUpScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.book_lover),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(top = 365.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Create Account",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            LazyColumn {
                item {
                    Column(
                        modifier = Modifier
                            .padding(
                                start = 30.dp,
                                end = 20.dp,
                                bottom = 10.dp,
                            )
                            //                    .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(.85f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        TextFieldComponent(
                            labelValue = "Name",
                            textValue = "",
                            onValueChange = {

                            }
                        )
                        Spacer(modifier = Modifier.height(35.dp))
                        EmailOutlinedTextFieldComponent(
                            labelValue = "Email",
                            textValue = "",
                            onValueChange = {

                            }
                        )
                        Spacer(modifier = Modifier.height(35.dp))
                        PasswordFieldComponent(
                            labelValue = "Password",
                            password = "",
                            onValueChange = {
                            }
                        )
                        Spacer(modifier = Modifier.height(60.dp))
                        CreateAcc(
                            onSignInButtonClicked = {
                            },
                            isLoading = false
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.weight(1f))
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
//                                start = 30.dp,
                                end = 30.dp,
                                bottom = 10.dp,
                            )
                    ) {
                        Text(
                            text = "Already have an account?",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.inverseSurface,
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        TextButton(
                            onClick = {
//                        navController.navigate(KethaScreens.ForgotPasswordScreen.route)
                            }) {
                            Text(
                                text = "Sign In",
                                textAlign = TextAlign.Start,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }

                }
            }

        }

    }

}

@Composable
fun CreateAcc(
    onSignInButtonClicked: () -> Unit,
    isLoading: Boolean
){
    Row {
        Text(
            text = "Create Account",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.inverseSurface,
        )
        Spacer(modifier = Modifier.weight(1f))
        if(isLoading){
            CircularProgressIndicator(
                modifier = Modifier.width(40.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = Color.LightGray
            )
        } else {
            IconButton(
                onClick = onSignInButtonClicked,
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.primary, CircleShape),

                ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Sign in",
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    ShelfariTheme {
        SignUpScreen()
    }
}