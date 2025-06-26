package com.example.simple_todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ViewModel: ViewModel() {
    private val _list  = MutableLiveData<List<Data>>()
    val list : LiveData<List<Data>> = _list

    fun getAllTodo(){
       _list.value = TodoManager.getAllTodo().reversed()

    }

    fun addTodo(input: String){
        TodoManager.addTodo(input)
        getAllTodo()
    }
}