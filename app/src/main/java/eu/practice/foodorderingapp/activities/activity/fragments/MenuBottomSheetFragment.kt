package eu.practice.foodorderingapp.activities.activity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import eu.practice.foodorderingapp.R
import eu.practice.foodorderingapp.activities.activity.adapter.MenuAdapter
import eu.practice.foodorderingapp.databinding.FragmentMenuBottomSheetBinding

class MenuBottomSheetFragment : BottomSheetDialogFragment() {

   private lateinit var binding : FragmentMenuBottomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(layoutInflater,container,false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }


        val menuFoodName = listOf("Burger","Pasta","Pizza","Momo","sandwich","Platter")
        val menuItemPrice = listOf("$50","$60","$70","$80","$90","$100",)
        val menuImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3
        )

        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(menuImage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter


        return binding.root
    }

    companion object {

    }
}