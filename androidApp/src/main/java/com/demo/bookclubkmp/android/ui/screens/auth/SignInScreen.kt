package com.demo.bookclubkmp.android.ui.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.bookclubkmp.android.R
import com.demo.bookclubkmp.android.ui.components.UILoading
import com.demo.bookclubkmp.domain.usecases.auth.InvalidPasswordException
import com.demo.bookclubkmp.domain.usecases.auth.InvalidUsernameException

@Composable
fun SignInScreen(
    uiState: MutableState<AuthViewModel.UIState> = mutableStateOf(AuthViewModel.UIState()),
    navigateToHome: () -> Unit = {},
    signIn: (username: String, password: String) -> Unit = { _, _ -> },
) {
    var username by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = uiState.value.session, block = {
        if (uiState.value.session != null) {
            navigateToHome()
        }
    })

    if (uiState.value.isLoading) {
        UILoading()
        return
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn( content = {
            item {
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 200.dp, bottom = 16.dp)) {
                    Text(text = "BookClub", style = MaterialTheme.typography.displayMedium)
                }
            }

            item {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = { Text(text = stringResource(id = R.string.login_username)) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp))
            }

            item {
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text(text = stringResource(id = R.string.login_password)) },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp))
            }

            item {
                Column(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    if (uiState.value.session != null) {
                        Text(text = stringResource(R.string.login_sign_in_success), color = MaterialTheme.colorScheme.primary)
                    }

                    if (uiState.value.exception is InvalidUsernameException) {
                        Text(text = stringResource(R.string.login_sign_in_error_username_format), color = MaterialTheme.colorScheme.error)
                    } else if (uiState.value.exception is InvalidPasswordException) {
                        Text(text = stringResource(R.string.login_sign_in_error_password_format), color = MaterialTheme.colorScheme.error)
                    } else if (uiState.value.exception != null) {
                        Text(text = stringResource(R.string.login_sign_in_error), color = MaterialTheme.colorScheme.error)
                    }
                }
            }

            item {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedButton(
                        modifier = Modifier.padding(16.dp),
                        onClick = {
                            signIn(username, password)
                        },
                        content = {
                            Text(text = stringResource(id = R.string.login_signin))
                        }
                    )

                    Text(modifier = Modifier.padding(8.dp), text = stringResource(R.string.login_forget_password))
                }
            }
        })
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    SignInScreen()
}