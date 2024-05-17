package com.example.qriz

import android.app.Application
import com.google.firebase.FirebaseApp

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // Firebase 초기화
        FirebaseApp.initializeApp(this)
    }
}