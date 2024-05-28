package com.example.qriz

import android.app.Application
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.qriz.ui.screen.LoginScreen
import com.example.qriz.ui.theme.QrizTheme
import com.example.qriz.viewModel.LoginViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            QrizTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(viewModel = loginViewModel)
                }
            }
        }
        lifecycleScope.launch {
            loginViewModel.loginResult.collectLatest {
                if(it){
                    loginViewModel.handleLoginSuccess(this@LoginActivity)
                }
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        loginViewModel.handleSignInResult(requestCode, resultCode, data)
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    QrizTheme {
        LoginScreen(viewModel = LoginViewModel(Application()))
    }
}