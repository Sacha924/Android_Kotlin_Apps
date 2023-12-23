package com.example.projet1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    fun onSocialIconClicked(view: View) {
        val service = when (view.id) {
            R.id.google -> "Google"
            R.id.facebook -> "Facebook"
            R.id.apple -> "Apple ID"
            else -> ""
        }

        val connectedTextView = findViewById<TextView>(R.id.connectedServiceTextView)
        connectedTextView.text = "Connected with $service"
        connectedTextView.visibility = View.VISIBLE // Rendez le TextView visible
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}