package com.example.qriz.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItems(
    val label : String,
    val icon : ImageVector,
    val route : String
)

val listOfNavItems = listOf(
    NavItems(
        label = "홈",
        icon = Icons.Default.Home,
        route = Screens.HomeScreen.name
    ),
    NavItems(
        label = "테스트",
        icon = Icons.Default.Search,
        route = Screens.TestScreen.name
    ),
    NavItems(
        label = "개념서",
        icon = Icons.Default.AccountCircle,
        route = Screens.BookScreen.name
    ),
    NavItems(
        label = "마이페이지",
        icon = Icons.Default.AccountCircle,
        route = Screens.MyPageScreen.name
    )
)