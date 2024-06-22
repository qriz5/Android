package com.example.qriz

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.qriz.ui.navigation.main.AppNavigation
import com.example.qriz.ui.theme.QrizTheme
import com.example.qriz.viewModel.MainActivityViewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel  : MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QrizTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   MyApp(mainViewModel)
                }
            }
        }
    }
}

@Composable
fun MyApp(viewModel: MainActivityViewModel) {
    val navController = rememberNavController()



    // 네비게이션 화면 표시
    AppNavigation(viewModel)

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QrizTheme {
       MyApp(viewModel = MainActivityViewModel(Application()) )
    }
}