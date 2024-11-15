package eu.practice.foodorderingapp.activities.activity.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eu.practice.foodorderingapp.activities.activity.activity.DetailsActivity
import eu.practice.foodorderingapp.databinding.PopularItemBinding

class PopularAdapter(
    private val items: List<String>,
    private val image: List<Int>,
    private val price: List<String>,
    private val requiredContext: Context
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    class PopularViewHolder(private val binding: PopularItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val imagesView = binding.foodImage
        fun bind(item: String, images: Int, price: String) {
            binding.menuFoodnamepopular.text = item
            binding.foodPrice.text = price
            imagesView.setImageResource(images)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            PopularItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item, images, price)

        holder.itemView.setOnClickListener {
            val intent = Intent(requiredContext, DetailsActivity::class.java).apply {
                putExtra("MenuItemName", item)
                putExtra("MenuItemImage", images)
            }
            requiredContext.startActivity(intent)

        }
    }
}