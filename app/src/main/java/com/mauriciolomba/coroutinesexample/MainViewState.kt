package com.mauriciolomba.coroutinesexample

sealed class MainViewState {

    object Idle: MainViewState()

    object Loading: MainViewState()

    object Success: MainViewState()

    object Executing: MainViewState()

}