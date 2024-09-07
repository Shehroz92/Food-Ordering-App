package eu.practice.foodorderingapp.activities.activity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.practice.foodorderingapp.R
import eu.practice.foodorderingapp.activities.activity.adapter.MenuAdapter
import eu.practice.foodorderingapp.databinding.FragmentHomeBinding
import eu.practice.foodorderingapp.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var binding : FragmentSearchBinding
    private lateinit var adapter: MenuAdapter

   private  val originalMenuFoodName = listOf("Burger","Pasta","Pizza","Momo","sandwich","Platter")
   private  val originalMenuItemPrice = listOf("$50","$60","$70","$80","$90","$100",)
   private  val originalMenuImage = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)

        adapter = MenuAdapter(originalMenuFoodName,originalMenuItemPrice,originalMenuImage)




        return binding.root
    }

}