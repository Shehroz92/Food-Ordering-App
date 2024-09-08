package eu.practice.foodorderingapp.activities.activity.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eu.practice.foodorderingapp.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName = intent.getStringExtra("MenuItemName")
        val foodImage = intent.getIntExtra("MenuItemImage",0)

        binding.detailsFoodName.text = foodName
        binding.detailsFoodImage.setImageResource(foodImage)


        binding.imageButton.setOnClickListener {
            finish()
        }

    }
}

