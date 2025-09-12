package com.example.android14.practicafinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val nameEditText = findViewById<EditText>(R.id.etNameLogin)
        val emailEditText = findViewById<EditText>(R.id.etEmailLogin)
        val confirmEmailEditText = findViewById<EditText>(R.id.etEmailConfirmLogin)
        val loginButton = findViewById<Button>(R.id.btnLogin)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val confirmEmail = confirmEmailEditText.text.toString()

            when{
                name.isEmpty() -> {nameEditText.error = getString(R.string.error_field_required)}
                email.isEmpty() -> {emailEditText.error = getString(R.string.error_field_required)}
                confirmEmail.isEmpty() -> {confirmEmailEditText.error = getString(R.string.error_field_required)}

                email != confirmEmail -> {
                    Toast.makeText(this, getString(R.string.error_emails_do_not_match), Toast.LENGTH_SHORT).show()
                }

                else -> {
                    val intent = Intent(this, WelcomeActivity::class.java)
                    intent.putExtra("USER_NAME", name)
                    intent.putExtra("USER_EMAIL", email)
                    startActivity(intent)
                }

            }
        }

    }
}