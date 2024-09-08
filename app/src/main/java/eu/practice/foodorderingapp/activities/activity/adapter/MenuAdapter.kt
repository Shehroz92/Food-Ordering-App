package eu.practice.foodorderingapp.activities.activity.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eu.practice.foodorderingapp.activities.activity.activity.DetailsActivity
import eu.practice.foodorderingapp.databinding.MenuItemsBinding

class MenuAdapter(
    private val menuItemsName: MutableList<String>,
    private val menuItemPrice: MutableList<String>,
    private var menuImage: MutableList<Int> ,
    private val requiredContext :Context
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val itemClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return menuItemsName.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menuItemsName[position], menuItemPrice[position], menuImage[position])
    }

    inner class MenuViewHolder(private val binding: MenuItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener.onItemClick(position)

                }

                // set on click listener for the open details
                val intent = Intent(requiredContext, DetailsActivity::class.java).apply {
                    putExtra("MenuItemName", menuItemsName.get(position))
                    putExtra("MenuItemImage", menuImage.get(position))
                }
                requiredContext.startActivity(intent)


            }
        }


        fun bind(foodName: String, foodPrice: String, foodImage: Int) {

            binding.apply {

                notificationName.text = foodName
                menuprice.text = foodPrice
                notificationImage.setImageResource(foodImage)


            }
        }
    }

    private fun Any?.onItemClick(position: Int) {
        // TODO
    }

}