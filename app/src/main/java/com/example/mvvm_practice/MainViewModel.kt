package com.example.mvvm_practice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application) {

    //androidViewModel을 상속받는데 요놈은 application을 매개변수로 받아와야함

    //Room DB init
    private val db = Room.databaseBuilder(
        //applicationContext,
        application,
        AppDatabase::class.java, "database-name"
    )
        //.allowMainThreadQueries()
        .build()



    fun getAll() : LiveData<List<Todo>>{
        return db.todoDao().getAll()
    }

    //suspend을 하면 해당 함수는 반드시 코루틴을 동반하여 사용해야 함
    suspend fun insert(todo : Todo){
        return db.todoDao().insert(todo)
    }
}