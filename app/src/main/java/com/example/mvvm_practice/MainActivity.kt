package com.example.mvvm_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
=======
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
>>>>>>> main
import androidx.room.Room
import com.example.mvvm_practice.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), View.OnClickListener{

    companion object{
        const val TAG : String = "로그"
    }

    // 나중에 값이 설정될 거라고 lateinit 으로 설정
    lateinit var myNumberViewModel: MyNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this //LiveData를 사용하기 위함

<<<<<<< HEAD
        // 뷰 모델 프로바이더를 통해 뷰 모델 가져오기
        // 라이프사이클을 가지고 있는 녀석을 넣어줌 즉, 자기 자신
        // 우리가 가져오고 싶은 뷰 모델 클래스를 넣어서 뷰 모델을 가져오기
        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        // 뷰 모델이 가지고 있는 값의 변경사항을 관찰할 수 있는 라이브 데이터를 옵저빙 한다.
        myNumberViewModel.currentValue.observe(this , Observer {
            Log.d(TAG , "MainActivity - myNumberViewModel - currentValue 라이브 데이터 값 변경 : $it")
            number_textview.text = it.toString()
        })

        plus_btn.setOnClickListener(this)
        minus_btn.setOnClickListener(this)
=======
        //val viewModel = ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)
        val viewModel : MainViewModel by viewModels()
        binding.viewModel = viewModel


>>>>>>> main

    }

    // 클릭
    override fun onClick(view: View?) {
        val userinput = userInput_edittext.text.toString().toInt()

        // 뷰 모델에 라이브데이터 값을 변경하는 메소드 실행
        when(view){
            plus_btn ->
                myNumberViewModel.updateValue(actionType = ActionType.PLUS , userinput)
            minus_btn ->
                myNumberViewModel.updateValue(actionType = ActionType.MINUS , userinput)
        }
    }
}