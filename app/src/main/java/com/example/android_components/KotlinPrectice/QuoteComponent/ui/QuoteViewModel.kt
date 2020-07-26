package com.example.android_components.KotlinPrectice.QuoteComponent.ui

import androidx.lifecycle.ViewModel
import com.example.android_components.KotlinPrectice.QuoteComponent.data.Quote
import com.example.android_components.KotlinPrectice.QuoteComponent.data.QuoteRepostory

class QuoteViewModel(val quoteRepostory: QuoteRepostory): ViewModel() {

    fun getQuoteData() = quoteRepostory.getQuote()

    fun setQuoteData(quote: String, author: String) = quoteRepostory.addQUote(Quote(quote,author))
}