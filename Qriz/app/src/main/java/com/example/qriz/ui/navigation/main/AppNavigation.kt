package com.example.qriz.ui.navigation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.qriz.ui.screen.Main.BookScreen
import com.example.qriz.ui.screen.Main.HomeScreen
import com.example.qriz.ui.screen.Main.MyPageScreen
import com.example.qriz.ui.screen.Main.TestScreen
import com.example.qriz.ui.screen.Onboarding.OnBoarding
import com.example.qriz.ui.screen.Onboarding.OnBoardingFinish
import com.example.qriz.ui.screen.Onboarding.OnBoardingStart
import com.example.qriz.viewModel.MainActivityViewModel


@Composable
fun AppNavigation(viewModel  : MainActivityViewModel) {
    val navController: NavHostController = rememberNavController()
    val firstLogin by viewModel.firstLogin.collectAsState()
    Scaffold(
        bottomBar = {
            if(!firstLogin){
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination: NavDestination? = navBackStackEntry?.destination

                    listOfNavItems.forEach { navItem ->
                        NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                            onClick = {
                                navController.navigate(navItem.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = { Icon(imageVector = navItem.icon, contentDescription = null) },
                            label = {
                                Text(text = navItem.label)
                            }
                        )
                    }
                }
            }


        }
    ) { paddingValues ->
        NavHost(navController = navController, startDestination = if(!firstLogin) Screens.HomeScreen.name else Screens.OnBoardingStart.name,
            modifier = Modifier.padding(paddingValues)) {
            composable(route = Screens.HomeScreen.name) {
                HomeScreen()
            }
            composable(route = Screens.TestScreen.name) {
                TestScreen()
            }
            composable(route = Screens.BookScreen.name) {
                BookScreen()
            }
            composable(route = Screens.MyPageScreen.name) {
                MyPageScreen()
            }
            composable(route = Screens.OnBoardingStart.name) {
                OnBoardingStart(navController)
            }
            composable(route = Screens.OnBoarding.name) {
                OnBoarding(navController )
            }
            composable(route = Screens.OnBoardingFinish.name) {
                OnBoardingFinish(navController)
            }
        }
    }
}