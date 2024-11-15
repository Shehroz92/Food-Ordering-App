package eu.practice.foodorderingapp.activities.activity.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import eu.practice.foodorderingapp.activities.activity.activity.DetailsActivity
import eu.practice.foodorderingapp.activities.activity.models.MenuItem
import eu.practice.foodorderingapp.databinding.MenuItemsBinding

class MenuAdapter(
    private var menuItem: List<MenuItem>,
    private val requiredContext: Context
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return menuItem.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class MenuViewHolder(private val binding: MenuItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    openDetailActivity(position)
                }
            }
        }

        private fun openDetailActivity(position: Int) {
            val menuItem = menuItem[position]
            // an intent to open details and pass data
            val intent = Intent(requiredContext, DetailsActivity::class.java).apply {
                putExtra("MenuItemName", menuItem.foodName)
                putExtra("MenuItemPrice", menuItem.foodPrice)
                putExtra("MenuItemDescription", menuItem.foodDescription)
                putExtra("MenuItemIngredients", menuItem.foodIngredient)
                putExtra("MenuItemImageUrl", menuItem.foodImage)
            }
            // start activity
            requiredContext.startActivity(intent)

        }

        // set data into recycler view item name , price , image

        fun bind(position: Int) {
            val menuItem = menuItem[position]
            binding.apply {
                foodName.text = menuItem.foodName
                foodPrice.text = menuItem.foodPrice
                val uri = Uri.parse(menuItem.foodImage)
                Glide.with(requiredContext).load(uri).into(foodImage)

            }
        }
    }

}