package eu.practice.foodorderingapp.activities.activity.activity


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import eu.practice.foodorderingapp.activities.activity.models.CartItems
import eu.practice.foodorderingapp.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private var foodName: String? = null
    private var foodImage: String? = null
    private var foodDescription: String? = null
    private var foodPrice: String? = null
    private var foodIngredients: String? = null
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  initialize Firebase auth
        auth = FirebaseAuth.getInstance()

        foodName = intent.getStringExtra("MenuItemName")
        foodImage = intent.getStringExtra("MenuItemImageUrl")
        foodDescription = intent.getStringExtra("MenuItemDescription")
        foodPrice = intent.getStringExtra("MenuItemPrice")
        foodIngredients = intent.getStringExtra("MenuItemIngredients")


        with(binding) {
            detailsFoodName.text = foodName
            detailsfoodDescription.text = foodDescription
            ingredientsfood.text = foodIngredients
            Glide.with(this@DetailsActivity).load(Uri.parse(foodImage)).into(detailsFoodImage)


        }

        binding.imageButton.setOnClickListener {
            finish()
        }
        binding.add.setOnClickListener {
            addItemToCart()
        }


    }

    private fun addItemToCart() {
        val database: DatabaseReference = FirebaseDatabase.getInstance().reference
        val userId = auth.currentUser?.uid ?: ""

        //Create a cart item object
        val cartItem = CartItems(
            foodName.toString(),
            foodPrice.toString(),
            foodDescription.toString(),
            foodImage.toString(),
            1,
            foodIngredients.toString()
        )
        // save item to cart to firebase
        database.child("user").child(userId).child("CartItems").push().setValue(cartItem)
            .addOnSuccessListener {
                Toast.makeText(this, "Items added into Cart Successfully 😁", Toast.LENGTH_SHORT)
                    .show()
            }.addOnFailureListener {
            Toast.makeText(this, "item not added 😣 ", Toast.LENGTH_SHORT).show()
        }


    }
}

