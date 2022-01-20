package com.example.mvvm_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.room.Room
import com.example.mvvm_practice.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        // 뷰 모델 가져오기
        val viewModel : CounterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        // 변경된 값을 찾아서 알아서 refesh해줌
        binding.setLifecycleOwner(this)
        binding.setViewModel(viewModel)

    }
}