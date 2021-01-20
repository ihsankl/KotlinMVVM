package com.example.kotlin_mvvm.utilities

import com.example.kotlin_mvvm.data.FakeDatabase
import com.example.kotlin_mvvm.data.QuoteRepository
import com.example.kotlin_mvvm.ui.QuotesViewModelFactory

object InjectorUtils {
    fun providerQuotesViewModelFactory():QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}