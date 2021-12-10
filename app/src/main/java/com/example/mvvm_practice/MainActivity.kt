package com.example.mvvm_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //ViewModel 가져오기
        //viewModel은 DB와 명령어를 가지고있음.
        val viewModel = ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)



        viewModel.getAll().observe(this, Observer { todos ->
            result_text.text = todos.toString()
        })



        //버튼 클릭 시 insert후 다시 표시
        //비동기 처리 = db의 allowMainThreadQueries()로 main스레드에 화면에 그리는 성능이 느려질 수 있다.
        //따라서 insert같은 것들을 백그라운드 스레드로 처리하는 것이 정석
        add_btn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {//백그라운드 스레드
                viewModel.insert(Todo(todo_edit.text.toString()))
            }
        }

    }
}