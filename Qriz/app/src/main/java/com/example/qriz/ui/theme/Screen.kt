package com.example.qriz.ui.theme

import androidx.annotation.StringRes
import com.example.qriz.R

sealed class Screen(val route : String, @StringRes val resourceId : Int) {
    object Home : Screen("home", R.string.home)
    object Test : Screen("search", R.string.test)
    object Book : Screen("book", R.string.book)
    object MyPage : Screen("myPage", R.string.myPage)



}