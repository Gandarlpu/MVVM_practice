package com.example.mvvm_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Room DB init
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()

        result_text.text = db.todoDao().getAll().toString()

        //버튼 클릭 시 insert후 다시 표시
        add_btn.setOnClickListener {
    
            // 1. insert로 디비에 집어넣고
            db.todoDao().insert(Todo(todo_edit.text.toString()))
            
            // 2. 새로고침
            result_text.text = db.todoDao().getAll().toString()

        }

    }
}