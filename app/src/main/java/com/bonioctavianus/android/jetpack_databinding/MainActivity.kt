package com.bonioctavianus.android.jetpack_databinding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bonioctavianus.android.jetpack_databinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainViewModel
    private lateinit var mViewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MainViewModel::class.java)

        observeViewState()

        mViewModel.getItems()
    }

    private fun observeViewState() {
        mViewModel.mState.observe(this, Observer { value ->
            mViewBinding.viewState = value

            when (value) {
                is MainViewState.Loaded -> {
                    val adapter = MainAdapter(value.items) { item ->
                        Toast.makeText(this, "Clicked item: ${item.title}", Toast.LENGTH_SHORT)
                            .show()
                    }
                    list_item.layoutManager = LinearLayoutManager(this)
                    list_item.adapter = adapter
                }
            }
        })
    }
}