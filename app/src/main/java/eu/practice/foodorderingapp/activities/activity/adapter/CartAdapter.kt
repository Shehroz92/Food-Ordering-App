package eu.practice.foodorderingapp.activities.activity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eu.practice.foodorderingapp.databinding.CartItemsBinding

class CartAdapter(private val cartItems:MutableList<String> , private val cartItemPrice:MutableList<String> , private var cartImage: MutableList<Int>  ) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartItems.size) { 1 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }


    inner class CartViewHolder(private val binding: CartItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartfoodname.text = cartItems[position]
                cartItemprice.text = cartItemPrice[position]
                cartimage.setImageResource(cartImage[position])
                cartItemQuantity.text = quantity.toString()

                minus.setOnClickListener {
                    decreaseQuantity(position)
                }
                plus.setOnClickListener {
                    increaseQuantity(position)

                }
                delete.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION){
                        deleteQuantity(itemPosition)
                    }


                }
            }
        }

          private  fun decreaseQuantity(position: Int) {
                if (itemQuantities[position] > 1) {
                    itemQuantities[position]--
                    binding.cartItemQuantity.text = itemQuantities[position].toString()
                }
            }

          private  fun increaseQuantity(position: Int) {
                if (itemQuantities[position] < 10) {
                    itemQuantities[position]++
                    binding.cartItemQuantity.text = itemQuantities[position].toString()
                }
            }

           private fun deleteQuantity(position: Int) {

                cartItems.removeAt(position)
                cartImage.removeAt(position)
                cartItemPrice.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, cartItems.size)
            }
        }
    }
