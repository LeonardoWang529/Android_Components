package com.example.android_components.KotlinPrectice.QuoteComponent.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_components.KotlinPrectice.QuoteComponent.data.DataBase
import com.example.android_components.KotlinPrectice.QuoteComponent.data.QuoteDAO
import com.example.android_components.KotlinPrectice.QuoteComponent.data.QuoteRepostory

class QuoteViewModelFactory(val quoteRepostory: QuoteRepostory): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuoteViewModel(quoteRepostory) as T
    }
}