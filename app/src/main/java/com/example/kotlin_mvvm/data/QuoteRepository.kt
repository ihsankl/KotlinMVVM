package com.example.kotlin_mvvm.data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){
    companion object{
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
                instance ?: synchronized(this){
                    instance ?: QuoteRepository(quoteDao).also { instance = it }
                }
    }

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()
}