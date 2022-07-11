package com.example.debtsapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.debtsapp.MainActivity
import com.example.debtsapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // login

        binding.loginButton.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            // intent.putExtra("username", currentUser.email)
            startActivity(intent)
        }
    }
}