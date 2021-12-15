package com.example.mvvm_practice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    //Room DB init
    private val db = Room.databaseBuilder(
        //applicationContext,
        application,
        AppDatabase::class.java, "database-name"
    )
        //.allowMainThreadQueries()
        .build()

    var todos : LiveData<List<Todo>>

    var newTodo : String? = null
    init {
        todos = getAll()
    }

    fun getAll() : LiveData<List<Todo>>{
        return db.todoDao().getAll()
    }

    fun insert(todo : String){
        viewModelScope.launch(Dispatchers.IO){
            db.todoDao().insert(Todo(todo))
        }
    }
}