package com.nazmul.api.service

import com.nazmul.model.UserRequest
import com.nazmul.model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {

    @POST("users/signup")
    suspend fun signUp(@Body userRequest: UserRequest) : Response<UserResponse>


    @POST("users/signin")
    suspend fun signIn(@Body userRequest: UserRequest) : Response<UserResponse>
}