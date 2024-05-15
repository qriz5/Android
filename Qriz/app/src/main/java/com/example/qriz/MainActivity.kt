package com.example.qriz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.qriz.ui.navigation.AppNavigation
import com.example.qriz.ui.screen.LoginScreen
import com.example.qriz.ui.theme.QrizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QrizTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    var isLoginIn by remember { mutableStateOf(false) }
    if (isLoginIn) {
        // 네비게이션 화면 표시
        AppNavigation(isLoginIn = isLoginIn)
    } else {
        // 로그인 화면 표시
        LoginScreen(onLoginSuccess = {
            // 로그인 성공 시
            isLoginIn = true // 로그인 상태를 변경

        })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QrizTheme {
       MyApp()
    }
}