package com.example.qriz.util.Helper

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.qriz.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class GoogleSignInHelper(private val context: Context) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val googleSignInClient: GoogleSignInClient

    companion object {
        const val RC_SIGN_IN = 9001
    }

    init {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestServerAuthCode(context.getString(R.string.default_web_client_id)) // 인증 코드 발급
//            .requestIdToken(context.getString(R.string.default_web_client_id)) // 토큰 발급
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(context, gso)
    }

    fun signIn(activity: Activity) {
        val signInIntent = googleSignInClient.signInIntent
        activity.startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    fun handleSignInResult(data: Intent?, onResult: (Result<String>) -> Unit) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {
            val account = task.getResult(ApiException::class.java)!!
            Log.d("GOOGLE", "handleSignInResult: ${account.serverAuthCode}") // 인증코드 발급
//            firebaseAuthWithGoogle(account.idToken!!, onResult) // 토큰 발급
            onResult(Result.success(account.serverAuthCode!!))
        } catch (e: ApiException) {
            onResult(Result.failure(e))
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String, onResult: (Result<String>) -> Unit) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                user?.getIdToken(true)?.addOnCompleteListener { tokenTask ->
                    if (tokenTask.isSuccessful) {
                        val idToken = tokenTask.result?.token
                        onResult(Result.success(idToken!!))
                    } else {
                        onResult(Result.failure(tokenTask.exception!!))
                    }
                }
            } else {
                onResult(Result.failure(task.exception!!))
            }
        }
    }
}
