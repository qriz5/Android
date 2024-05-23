package com.example.qriz.viewModel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.AndroidViewModel
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
import com.kakao.sdk.auth.AuthCodeClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

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

    private val context = application.applicationContext
    fun trySignin(context : Context){

    }


    fun configureGoogleSignIn() {
        googleSignInHelper = GoogleSignInHelper(context)
    }

    fun googleSignIn() {
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

    fun kakaoLogin(){
        val callback: (String?, Throwable?) -> Unit = { authCode, error ->
            if (error != null) {
                Log.e("카카오 로그인", "카카오계정으로 로그인 실패", error)
            } else if (authCode != null) {
                Log.i("카카오 로그인", "카카오계정으로 로그인 성공 ${authCode}")
            }
        }

// 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        if (AuthCodeClient.instance.isKakaoTalkLoginAvailable(context)) {
            AuthCodeClient.instance.authorizeWithKakaoAccount(context) { authCode, error ->
                if (error != null) {
                    Log.e("카카오 로그인", "카카오톡으로 로그인 실패", error)

                    // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                    // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@authorizeWithKakaoAccount
                    }

                    // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                    AuthCodeClient.instance.authorizeWithKakaoAccount(context, callback = callback)
                } else if (authCode != null) {
                    Log.i("카카오 로그인", "카카오톡으로 로그인 성공 ${authCode}")
                }
            }
        } else {
            AuthCodeClient.instance.authorizeWithKakaoAccount(context, callback = callback)
        }

    }



}