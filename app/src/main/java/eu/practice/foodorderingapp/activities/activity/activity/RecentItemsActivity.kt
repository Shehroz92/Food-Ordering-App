package eu.practice.foodorderingapp.activities.activity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import eu.practice.foodorderingapp.R
import eu.practice.foodorderingapp.activities.activity.adapter.RecentBuyAdapter
import eu.practice.foodorderingapp.activities.activity.models.OrderDetails
import eu.practice.foodorderingapp.databinding.ActivityRecentItemsBinding
import eu.practice.foodorderingapp.databinding.RecentBuyItemBinding

class RecentItemsActivity : AppCompatActivity() {

    private val binding: ActivityRecentItemsBinding by lazy {
        ActivityRecentItemsBinding.inflate(layoutInflater)
    }
    private lateinit var allFoodNames: ArrayList<String>
    private lateinit var allFoodImages: ArrayList<String>
    private lateinit var allFoodPrices: ArrayList<String>
    private lateinit var allFoodQuantities: ArrayList<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }

        val recentOrderItems =
            intent.getSerializableExtra("RecentBuyOrderItems") as ArrayList<OrderDetails>
        recentOrderItems?.let { orderDetails ->
            if (orderDetails.isNotEmpty()) {
                val recentOrderItem = orderDetails[0]

                allFoodNames = recentOrderItem.foodNames as ArrayList<String>
                allFoodPrices = recentOrderItem.foodPrices as ArrayList<String>
                allFoodQuantities = recentOrderItem.foodQuantities as ArrayList<Int>
                allFoodImages = recentOrderItem.foodImage as ArrayList<String>
            }
        }
        setAdapter()
    }

    private fun setAdapter() {
        val rv = binding.recentBuyRecyclerView
        rv.layoutManager = LinearLayoutManager(this)
        val adapter =
            RecentBuyAdapter(this, allFoodNames, allFoodImages, allFoodPrices, allFoodQuantities)
        rv.adapter = adapter
    }
}