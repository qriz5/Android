package com.example.qriz.viewModel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qriz.R
import com.example.qriz.model.SocialLoginRequest
import com.example.qriz.repository.RetrofitInstance
import com.example.qriz.util.Helper.GoogleSignInHelper
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    companion object {
        const val RC_SIGN_IN = 9001 // Google Sign-In 요청 코드
    }

    data class LoginUiState(
        val isLoading: Boolean = false
    )

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState
    private lateinit var googleSignInHelper: GoogleSignInHelper

    private val _loginResult = MutableSharedFlow<Boolean>()
    var loginResult = _loginResult.asSharedFlow()

    fun trySignin(context : Context){

    }


    fun configureGoogleSignIn(context: Context) {
        googleSignInHelper = GoogleSignInHelper(context)
    }

    fun googleSignIn(context: Context) {
        googleSignInHelper.signIn(context as Activity)
    }

    fun handleSignInResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == GoogleSignInHelper.RC_SIGN_IN) {
            googleSignInHelper.handleSignInResult(data) { result ->
                result.onSuccess { authCode ->
                    Log.d("GoogleLogin", "handleSignInResult: $authCode")
                    sendAuthCodeToServer(authCode)
                }.onFailure {
                    // Handle error
                }
            }
        }
    }

    private fun sendAuthCodeToServer(authCode : String?){
        viewModelScope.launch {
            try {
                val tokenRequest = SocialLoginRequest("google",authCode ?: "")
                val response = RetrofitInstance.api.verifyToken(tokenRequest)
            }
            catch (e : Exception){

            }
        }
    }

    private fun sendTokenToServer(idToken: String?) {
        viewModelScope.launch {
            try {
                val tokenRequest = SocialLoginRequest("google",idToken ?: "")
                val response = RetrofitInstance.api.verifyToken(tokenRequest)
                // 서버 응답 처리
            } catch (e: Exception) {
                // 에러 처리
            }
        }
    }
}