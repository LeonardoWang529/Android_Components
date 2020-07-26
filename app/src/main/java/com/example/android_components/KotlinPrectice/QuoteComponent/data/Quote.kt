package com.example.android_components.KotlinPrectice.QuoteComponent.data

class Quote (val quoteText: String, val author: String){
    override fun toString(): String {
        return "$quoteText - $author"
    }
}