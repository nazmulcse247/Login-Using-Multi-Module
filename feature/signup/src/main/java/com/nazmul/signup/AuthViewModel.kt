package com.nazmul.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nazmul.common.utils.NetworkResult
import com.nazmul.data.repository.AuthRepository
import com.nazmul.model.UserRequest
import com.nazmul.model.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    val authLiveData : LiveData<NetworkResult<UserResponse>>
        get() = authRepository.authLiveData

    fun registerUser(userRequest: UserRequest){
        viewModelScope.launch {
            authRepository.registerUser(userRequest)
        }
    }

    fun loginUser(userRequest: UserRequest) {
        viewModelScope.launch {
            authRepository.loginUser(userRequest)
        }
    }


}