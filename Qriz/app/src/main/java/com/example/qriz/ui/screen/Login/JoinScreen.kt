package com.example.qriz.ui.screen.Login

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qriz.ui.screen.Join.CheckEmailScreen
import com.example.qriz.ui.screen.Join.InputEmailScreen
import com.example.qriz.ui.screen.Join.InputIDScreen
import com.example.qriz.ui.screen.Join.InputNameScreen
import com.example.qriz.ui.screen.Join.InputPassScreen
import com.example.qriz.viewModel.LoginViewModel

@Composable
fun JoinScreen(navController: NavController, viewModel : LoginViewModel){
    Surface {
        val joinController = rememberNavController()
        NavHost(navController = joinController, startDestination = "InputName") {
            composable("InputName") { InputNameScreen(navController = joinController, parentNavController = navController, viewModel) }
            composable("InputEmail") { InputEmailScreen(joinController, viewModel) }
            composable("CheckEmail") { CheckEmailScreen(joinController, viewModel) }
            composable("InputID") { InputIDScreen(joinController, viewModel) }
            composable("InputPass") { InputPassScreen(navController = joinController, parentNavController = navController, viewModel) }

        }
    }
}