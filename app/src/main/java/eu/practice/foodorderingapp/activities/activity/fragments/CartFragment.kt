package eu.practice.foodorderingapp.activities.activity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import eu.practice.foodorderingapp.R
import eu.practice.foodorderingapp.activities.activity.adapter.CartAdapter
import eu.practice.foodorderingapp.databinding.CartItemsBinding
import eu.practice.foodorderingapp.databinding.FragmentCartBinding


class CartFragment : Fragment() {
private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodName = listOf("Burger","Pasta","Pizza","Momo","sandwich","Platter")
        val cartItemPrice = listOf("$50","$60","$70","$80","$90","$100",)
        val cartImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3
        )

        val adapter = CartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecycler.adapter=adapter
        return binding.root

    }


    companion object{

    }
}
