package eu.practice.foodorderingapp.activities.activity.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eu.practice.foodorderingapp.databinding.ActivityStartBinding

class Start : AppCompatActivity() {

    private val binding: ActivityStartBinding by lazy {
        ActivityStartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.nextButton.setOnClickListener {
            val intent = Intent(this@Start, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}