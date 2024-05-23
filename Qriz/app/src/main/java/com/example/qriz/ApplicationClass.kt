package com.example.qriz

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // Firebase 초기화카
        FirebaseApp.initializeApp(this)
        KakaoSdk.init(this, BuildConfig.KAKAO_APP_KEY)
        var keyHash = Utility.getKeyHash(this)
        Log.d("카카오 해시 키", "onCreate: $keyHash")
    }
}