package eu.practice.foodorderingapp.activities.activity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import eu.practice.foodorderingapp.R
import eu.practice.foodorderingapp.activities.activity.adapter.PopularAdapter
import eu.practice.foodorderingapp.activities.activity.adapter.SliderAdapter
import eu.practice.foodorderingapp.databinding.FragmentHomeBinding


@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.viewMenu.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }


         return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1 , ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.redbanner , ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.fast ,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)

        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(),itemMessage , Toast.LENGTH_SHORT).show()
            }
        })

        val foodName = listOf("Burger", "sandwich" ,"momo","Pasta","Pizza","sandwich" ,"momo","Pasta","Pizza")
        val price = listOf("$50","$60","$70","$80","$90","$60","$70","$80","$90")
        val popularFoodItems = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu2,R.drawable.menu1,R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu2)

        val adapter  =  PopularAdapter(foodName,popularFoodItems,price,requireContext())
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter





    }


}