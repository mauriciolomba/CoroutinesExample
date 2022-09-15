package com.mauriciolomba.coroutinesexample.userprofile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

internal class UserProfileViewModel : ViewModel() {

    private val coroutineRepository = UserProfileRepository()

    private val _state: MutableLiveData<UserProfileViewState> = MutableLiveData()
    val state: LiveData<UserProfileViewState>
        get() = _state

    fun fetchUserName() = viewModelScope.launch {
        _state.value = UserProfileViewState.Loading
        val userName = coroutineRepository.fetchUserData()
        _state.value = UserProfileViewState.Success(userName = userName)
    }

}