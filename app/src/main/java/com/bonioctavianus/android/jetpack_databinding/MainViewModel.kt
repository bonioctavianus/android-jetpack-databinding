package com.bonioctavianus.android.jetpack_databinding

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val mState: MutableLiveData<MainViewState> = MutableLiveData()

    fun getItems() {
        val items = listOf(
            Item("Item 1", "Item 1 description", R.drawable.ic_android, true),
            Item("Item 2", "Item 2 description", R.drawable.ic_android, true),
            Item("Item 3", "Item 3 description", R.drawable.ic_android, false),
            Item("Item 4", "Item 4 description", R.drawable.ic_android, false),
            Item("Item 5", "Item 5 description", R.drawable.ic_android, false),
            Item("Item 6", "Item 6 description", R.drawable.ic_android, true),
            Item("Item 7", "Item 7 description", R.drawable.ic_android, false),
            Item("Item 8", "Item 8 description", R.drawable.ic_android, true),
            Item("Item 9", "Item 9 description", R.drawable.ic_android, false),
            Item("Item 10", "Item 10 description", R.drawable.ic_android, true)
        )

        mState.postValue(MainViewState.InFlight)
        Handler().postDelayed({
            mState.postValue(MainViewState.Loaded(items))
        }, 2000)
    }
}