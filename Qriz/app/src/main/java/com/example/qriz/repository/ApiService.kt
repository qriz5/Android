package com.example.qriz.repository

import com.example.qriz.model.LoginResponse
import com.example.qriz.model.SocialLoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("verifyToken")
    suspend fun verifyToken(@Body tokenRequest: SocialLoginRequest): LoginResponse
}
