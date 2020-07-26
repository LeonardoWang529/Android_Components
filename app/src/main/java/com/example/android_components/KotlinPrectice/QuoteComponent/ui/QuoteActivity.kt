package com.example.android_components.KotlinPrectice.QuoteComponent.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android_components.KotlinPrectice.QuoteComponent.utilites.InjectUtil
import com.example.android_components.R
import kotlinx.android.synthetic.main.activity_quote.*
import kotlinx.android.synthetic.main.activity_quote.view.*
import kotlinx.android.synthetic.main.activity_quote.view.quote_content

class QuoteActivity: AppCompatActivity() {
    //private lateinit var binding: ActivityQuoteBinding
    private lateinit var viewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*binding = ActivityQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)*/
        setContentView(R.layout.activity_quote)

        viewModel = ViewModelProvider(this, InjectUtil.provideQuoteViewModelFactory()).get(QuoteViewModel::class.java)

        viewModel.getQuoteData().observe(this, Observer {
            quotes -> quotes.forEach { quote -> quote_content?.text = quote.toString() }
        })

        submit.setOnClickListener {
            viewModel.setQuoteData(quote_text.text.toString(),quote_author.text.toString())
        }
    }
}