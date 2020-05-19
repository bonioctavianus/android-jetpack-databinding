package com.bonioctavianus.android.jetpack_databinding

import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

@BindingAdapter("android:src")
fun ImageView.setImageViewResources(@DrawableRes image: Int) {
    setImageResource(image)
}

@BindingAdapter("inFlightVisibility")
fun View.inFlightVisibility(state: MainViewState) {
    visibility = if (state is MainViewState.InFlight) View.VISIBLE else View.GONE
}

@BindingAdapter("contentVisibility")
fun View.contentVisibility(state: MainViewState) {
    visibility = if (state is MainViewState.Loaded) View.VISIBLE else View.GONE
}

@BindingAdapter("errorVisibility")
fun View.errorVisibility(state: MainViewState) {
    visibility = if (state is MainViewState.Error) View.VISIBLE else View.GONE
}