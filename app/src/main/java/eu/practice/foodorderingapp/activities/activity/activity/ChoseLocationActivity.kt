package eu.practice.foodorderingapp.activities.activity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import eu.practice.foodorderingapp.R
import eu.practice.foodorderingapp.databinding.ActivityChoseLocationBinding

class ChoseLocationActivity : AppCompatActivity() {

    private val binding: ActivityChoseLocationBinding by lazy {
        ActivityChoseLocationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val locationList: Array<String> = arrayOf("Karachi", "Lahore", "Islamabad", "Multan")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locationList)
        val autoCompleteTextView = binding.listofLocation
        autoCompleteTextView.setAdapter(adapter)

    }
}