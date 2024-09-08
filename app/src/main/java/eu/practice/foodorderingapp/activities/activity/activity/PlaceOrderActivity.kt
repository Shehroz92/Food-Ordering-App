package eu.practice.foodorderingapp.activities.activity.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import eu.practice.foodorderingapp.R
import eu.practice.foodorderingapp.activities.activity.fragments.CongratsBottomSheet
import eu.practice.foodorderingapp.databinding.ActivityPlaceOrderBinding

class PlaceOrderActivity : AppCompatActivity() {

    private  lateinit var binding:ActivityPlaceOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.placeButton.setOnClickListener {
            val bottomSheetDialog = CongratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager,"Test")

        }
    }
}
