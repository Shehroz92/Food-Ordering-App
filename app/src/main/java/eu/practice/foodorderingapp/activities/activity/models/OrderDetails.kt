package eu.practice.foodorderingapp.activities.activity.models

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class OrderDetails() : Serializable {

    var userUid: String? = null
    var userName: String? = null
    var address: String? = null
    var totalAmount: String? = null
    var itemPushKey: String? = null
    var phoneNumber: String? = null
    var foodImage: MutableList<String>? = null
    var foodNames: MutableList<String>? = null
    var foodPrices: MutableList<String>? = null
    var foodQuantities: MutableList<Int>? = null
    var orderAccepted: Boolean = false
    var paymentReceived: Boolean = false
    var currentTime: Long = 0

    constructor(parcel: Parcel) : this() {
        userUid = parcel.readString()
        userName = parcel.readString()
        address = parcel.readString()
        totalAmount = parcel.readString()
        itemPushKey = parcel.readString()
        phoneNumber = parcel.readString()
        foodImage = parcel.createStringArrayList()
        foodNames = parcel.createStringArrayList()
        foodPrices = parcel.createStringArrayList()
        foodQuantities = parcel.createIntArray()?.toMutableList()
        orderAccepted = parcel.readByte() != 0.toByte()
        paymentReceived = parcel.readByte() != 0.toByte()
        currentTime = parcel.readLong()
    }

    constructor(
        userId: String,
        name: String,
        foodItemName: ArrayList<String>,
        foodItemPrice: ArrayList<String>,
        foodItemImage: ArrayList<String>,
        foodItemQuantities: ArrayList<Int>,
        address: String,
        phone: String,
        time: Long,
        itemPushKey: String?,
        orderAccepted: Boolean,
        paymentReceived: Boolean
    ) : this() {
        this.userUid = userId
        this.userName = name
        this.foodNames = foodItemName
        this.foodPrices = foodItemPrice
        this.foodImage = foodItemImage
        this.foodQuantities = foodItemQuantities
        this.address = address
        this.phoneNumber = phone
        this.currentTime = time
        this.itemPushKey = itemPushKey
        this.orderAccepted = orderAccepted
        this.paymentReceived = paymentReceived
        this.totalAmount = calculateTotalPrice()
    }

    private fun calculateTotalPrice(): String {
        var total = 0
        if (foodPrices != null && foodQuantities != null) {
            for (i in foodPrices!!.indices) {
                val price = foodPrices!![i].replace("$", "").toInt()
                total += price * foodQuantities!![i]
            }
        }
        return "$total$"
    }

     fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userUid)
        parcel.writeString(userName)
        parcel.writeString(address)
        parcel.writeString(totalAmount)
        parcel.writeString(itemPushKey)
        parcel.writeString(phoneNumber)
        parcel.writeStringList(foodImage)
        parcel.writeStringList(foodNames)
        parcel.writeStringList(foodPrices)
        parcel.writeIntArray(foodQuantities?.toIntArray())
        parcel.writeByte(if (orderAccepted) 1 else 0)
        parcel.writeByte(if (paymentReceived) 1 else 0)
        parcel.writeLong(currentTime)
    }

     fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OrderDetails> {
        override fun createFromParcel(parcel: Parcel): OrderDetails {
            return OrderDetails(parcel)
        }

        override fun newArray(size: Int): Array<OrderDetails?> {
            return arrayOfNulls(size)
        }
    }
}
