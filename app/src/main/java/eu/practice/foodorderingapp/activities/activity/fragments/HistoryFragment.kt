package eu.practice.foodorderingapp.activities.activity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import eu.practice.foodorderingapp.R
import eu.practice.foodorderingapp.activities.activity.adapter.BuyAgainAdapter
import eu.practice.foodorderingapp.databinding.BuyAgainItemBinding
import eu.practice.foodorderingapp.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)

        setupRecycleView()

        return binding.root
    }

    private fun setupRecycleView() {
        val buyAgainFoodName =
            arrayListOf("Food 1", "Food 2", "Food 3", "Food 4", "Food 5", "Food 6", "Food 7")
        val buyAgainFoodPrice = arrayListOf("$45", "$25", "$35", "$54", "$25", "$35", "$54")
        val buyAgainFoodImage = arrayListOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4
        )
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage)
        binding.buyagainRecycler.adapter = buyAgainAdapter
        binding.buyagainRecycler.layoutManager = LinearLayoutManager(requireContext())

    }


}