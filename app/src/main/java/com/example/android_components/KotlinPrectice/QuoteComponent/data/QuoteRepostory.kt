package com.example.android_components.KotlinPrectice.QuoteComponent.data

class QuoteRepostory private constructor(val quoteDAO: QuoteDAO){


    companion object{
        @Volatile private var instance: QuoteRepostory ?= null
        fun getInstance(quoteDao: QuoteDAO) = instance ?: synchronized(this){
            instance ?: QuoteRepostory(quoteDao).also { instance = it }
        }
    }

    fun getQuote() = quoteDAO.getQuotes()

    fun addQUote(quote: Quote) = quoteDAO.addQuote(quote)
}