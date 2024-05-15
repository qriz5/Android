package com.example.qriz.ui.screen

import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun LoginScreen( onLoginSuccess : () -> Unit){
    Surface {
        Text(text = "로그인 화면")
        Button(onClick = {onLoginSuccess()}) {
            Text(text = "로그인")
        }
    }
}