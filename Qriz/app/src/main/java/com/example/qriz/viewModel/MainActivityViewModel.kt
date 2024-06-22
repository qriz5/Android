package com.example.qriz.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val _firstLogin = MutableStateFlow(true)
    var firstLogin : StateFlow<Boolean> = _firstLogin


}