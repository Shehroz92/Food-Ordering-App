package eu.practice.foodorderingapp.activities.activity.models

data class CartItems(
    var foodName: String? = null,
    var foodPrice: String? = null,
    var foodDescription: String? = null,
    var foodImage: String? = null,
    var foodQuantity: Int? = null,
    var foodIngredient: String
) {
    // Default constructor for Firebase
    constructor() : this("", "", "", "", 0, "")
}

