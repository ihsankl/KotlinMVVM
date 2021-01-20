package com.example.kotlin_mvvm.ui

import androidx.lifecycle.ViewModel
import com.example.kotlin_mvvm.data.Quote
import com.example.kotlin_mvvm.data.QuoteRepository

class QuotesViewModel(private val quoteRepository:QuoteRepository):ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

}