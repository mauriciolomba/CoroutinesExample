package com.mauriciolomba.coroutinesexample.userprofile

internal sealed class UserProfileViewState {

    object Loading : UserProfileViewState()

    data class Success(val userName: String) : UserProfileViewState()
}