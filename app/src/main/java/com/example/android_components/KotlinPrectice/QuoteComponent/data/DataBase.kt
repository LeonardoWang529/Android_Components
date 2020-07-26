package com.example.android_components.KotlinPrectice.QuoteComponent.data

class DataBase private constructor(){

    var quoteDAO = QuoteDAO()
    private set

    companion object{
        @Volatile private var instance: DataBase ?= null

        fun getInstance() = instance ?: synchronized(this){
            instance ?: DataBase().also { instance = it }
        }
    }
}