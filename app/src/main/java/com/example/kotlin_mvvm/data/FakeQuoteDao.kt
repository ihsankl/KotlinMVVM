package com.example.kotlin_mvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quotelist = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quotelist
    }

    fun addQuote(quote: Quote){
        quotelist.add(quote)
        quotes.value = quotelist
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}