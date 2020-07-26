package com.example.android_components.KotlinPrectice.QuoteComponent.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuoteDAO {
    val quteList = mutableListOf<Quote>()
    val multableQuteList = MutableLiveData<List<Quote>>()

    init {
        multableQuteList.value = quteList
    }

    fun addQuote(quote: Quote){
        quteList.add(quote)
        multableQuteList.value = quteList
    }

    fun getQuotes() = multableQuteList as LiveData<List<Quote>>

}