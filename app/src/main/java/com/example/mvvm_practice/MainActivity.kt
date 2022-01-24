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

class MainActivity : AppCompatActivity() , View.OnClickListener{

    companion object{
        const val TAG : String = "로그"
    }

    lateinit var myNumberViewModel: MyNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        // 뷰 모델 라이브 데이터 접근
        myNumberViewModel.currentValue.observe(this , Observer {
            Log.d(TAG, "Main - ViewModel - currentValue 라이브 데이터 값 변경 : ${it}")
            textView.text = it.toString()
        })

        plus_btn.setOnClickListener(this)
        minus_btn.setOnClickListener(this)

    }

    // 클릭 이벤트
    override fun onClick(view: View?) {
        val userInput = userinput_edittext.text.toString().toInt()

        when(view){
            plus_btn -> {
                myNumberViewModel.updateValue(actionType = ActionType.PLUS , userInput)
            }
            minus_btn -> {
                myNumberViewModel.updateValue(actionType = ActionType.MINUS , userInput)
            }
        }

    }
}