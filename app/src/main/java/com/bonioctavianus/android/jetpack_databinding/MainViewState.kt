package com.bonioctavianus.android.jetpack_databinding

sealed class MainViewState {
    object InFlight : MainViewState()
    data class Loaded(val items: List<Item>) : MainViewState()
    data class Error(val throwable: Throwable?) : MainViewState()
}