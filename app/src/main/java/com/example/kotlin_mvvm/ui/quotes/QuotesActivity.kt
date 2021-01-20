package com.example.kotlin_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kotlin_mvvm.R
import com.example.kotlin_mvvm.data.Quote
import com.example.kotlin_mvvm.databinding.ActivityMainBinding
import com.example.kotlin_mvvm.utilities.InjectorUtils

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initializeUi()
    }

    private fun initializeUi(){
        val factory = InjectorUtils.providerQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory)
                .get(QuotesViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{quote ->
                stringBuilder.append("$quote\n\n")
            }
            binding.tvQuotes.text = stringBuilder.toString()
        })

        binding.btnAddQuote.setOnClickListener{
            val quote = Quote(binding.etQuote.text.toString(), binding.etAuthor.text.toString())
            viewModel.addQuote(quote)
            binding.etQuote.setText("")
            binding.etAuthor.setText("")
        }
    }
}