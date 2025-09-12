package com.example.android14.practicafinal

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val welcomeNameText = findViewById<TextView>(R.id.tvWelcome)
        val welcomeEmailText = findViewById<TextView>(R.id.tvEmailIs)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = getString(R.string.login_title)


        val defaultName = getString(R.string.default_guest_name)
        val defaultEmail = getString(R.string.default_no_email)

        val userName = intent.getStringExtra("USER_NAME") ?: defaultName
        val userEmail = intent.getStringExtra("USER_EMAIL") ?: defaultEmail


        val welcomeText = getString(R.string.welcome_message, userName)
        val emailText = getString(R.string.your_email_is, userEmail)

        welcomeNameText.text = welcomeText
        welcomeEmailText.text = emailText

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}