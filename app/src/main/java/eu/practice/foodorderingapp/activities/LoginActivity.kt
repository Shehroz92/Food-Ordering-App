package eu.practice.foodorderingapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eu.practice.foodorderingapp.R
import eu.practice.foodorderingapp.databinding.ActivityLoginBinding
import eu.practice.foodorderingapp.databinding.ActivityStartBinding

class LoginActivity : AppCompatActivity() {

    private val binding : ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.donthaveaccount.setOnClickListener{
            val intent = Intent(this@LoginActivity , SignUpActivity::class.java )
            startActivity(intent)
            finish()

        }

    }
}