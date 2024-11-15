package eu.practice.foodorderingapp.activities.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eu.practice.foodorderingapp.databinding.NotificationItemBinding

class NotificationAdapter(
    private var notification: List<String>,
    private var notificationImage: List<Int>
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val binding =
            NotificationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return notification.size
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val item = notification[position]
        val images = notificationImage[position]
        holder.bind(item, images)
    }

    inner class NotificationViewHolder(private val binding: NotificationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, images: Int) {
            val imageView = binding.foodImage
            binding.apply {
                foodName.text = item
                imageView.setImageResource(images)
            }
        }
    }
}
