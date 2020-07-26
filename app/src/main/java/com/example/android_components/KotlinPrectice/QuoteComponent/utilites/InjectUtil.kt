package com.example.android_components.KotlinPrectice.QuoteComponent.utilites

import com.example.android_components.KotlinPrectice.QuoteComponent.data.DataBase
import com.example.android_components.KotlinPrectice.QuoteComponent.data.QuoteRepostory
import com.example.android_components.KotlinPrectice.QuoteComponent.ui.QuoteViewModelFactory

object InjectUtil {

    fun provideQuoteViewModelFactory(): QuoteViewModelFactory{
        return QuoteViewModelFactory(QuoteRepostory.getInstance(DataBase.getInstance().quoteDAO))
    }
}