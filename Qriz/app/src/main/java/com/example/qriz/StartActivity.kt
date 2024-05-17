package com.example.qriz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.qriz.ui.theme.QrizTheme
import com.example.qriz.viewModel.LoginViewModel
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class StartActivity : ComponentActivity() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            QrizTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 로그인 시도
                    viewModel.trySignin(this)

                    lifecycleScope.launchWhenCreated {
                        viewModel.loginResult.collect { isLogin ->
                            if (isLogin) {
                                if (auth.currentUser != null) {
                                    startActivity(Intent(this@StartActivity, MainActivity::class.java))
                                }
                            } else {
                                // 로그인 안되어있을 때 로그인 페이지 열림
                                startActivity(Intent(this@StartActivity, LoginActivity::class.java))
                            }
                        }
                    }
                    setContent {
                        Surface(color = Color.White) {
                            Text(text = "로그인 확인중", fontSize = 30.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    QrizTheme {
        Greeting("Android")
    }
}