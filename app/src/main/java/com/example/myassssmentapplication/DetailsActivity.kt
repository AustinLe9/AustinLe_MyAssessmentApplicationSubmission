package com.example.myassssmentapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        val tvProperty1: TextView = findViewById(R.id.tvProperty1)
        val tvProperty2: TextView = findViewById(R.id.tvProperty2)
        val tvDomain: TextView = findViewById(R.id.tvDomain)
        val tvSymbol: TextView = findViewById(R.id.tvSymbol)
        val tvParentage: TextView = findViewById(R.id.tvParentage)
        val tvromanEquivalent: TextView = findViewById(R.id.tvromanEquivalent)
        val tvDescription: TextView = findViewById(R.id.tvDescription)


        tvProperty1.text = intent.getStringExtra("name") ?: "N/A"
        val culture = intent.getStringExtra("culture") ?: "N/A"
        val domain = intent.getStringExtra("domain") ?: "N/A"
        val symbol  = intent.getStringExtra("symbol") ?: "N/A"
        val parentage   = intent.getStringExtra("parentage") ?: "N/A"
        val romanEquivalent = intent.getStringExtra("romanEquivalent") ?: "N/A"
        val description = intent.getStringExtra("description") ?: "N/A"

        // In your DetailsActivity.kt, where you set the text:

        tvProperty2.text = "Culture: " + culture
        tvDomain.text = "Domain: " + domain
        tvSymbol.text = "Symbol: " + symbol
        tvParentage.text = "Parentage: " + parentage
        tvromanEquivalent.text = "Roman Equivalent: " + romanEquivalent
        tvDescription.text = "Description: " + description
    }
}
