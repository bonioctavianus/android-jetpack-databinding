package com.bonioctavianus.android.jetpack_databinding

import androidx.annotation.DrawableRes

data class Item(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
    val favorite: Boolean
)