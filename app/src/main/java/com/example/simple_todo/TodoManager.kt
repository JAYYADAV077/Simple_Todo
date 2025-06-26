package com.example.simple_todo

object TodoManager {
   val listt = mutableListOf<Data>()

    fun getAllTodo():List<Data>{
        return listt
    }

    fun addTodo(input: String){
        listt.add(Data(System.currentTimeMillis().toInt(),input))
        getAllTodo()
    }

}