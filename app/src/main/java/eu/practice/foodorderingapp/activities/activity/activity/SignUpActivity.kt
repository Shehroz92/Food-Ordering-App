package eu.practice.foodorderingapp.activities.activity.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eu.practice.foodorderingapp.databinding.ActivitySigUpBinding

class SignUpActivity : AppCompatActivity() {

    private val binding : ActivitySigUpBinding by lazy {
        ActivitySigUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.alreadyHaveAnAccount.setOnClickListener{
            val intent = Intent (this@SignUpActivity , LoginActivity::class.java )
            startActivity(intent)
            finish()
        }

        binding.buttonCreatAccount.setOnClickListener{
            val intent = Intent (this@SignUpActivity , LoginActivity::class.java )
            startActivity(intent)
            finish()

        }
    }
}
