package eu.practice.foodorderingapp.activities.activity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import eu.practice.foodorderingapp.R
import eu.practice.foodorderingapp.activities.activity.adapter.NotificationAdapter
import eu.practice.foodorderingapp.databinding.FragmentNotificationBottomBinding

class NotificationBottomFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater, container, false)

        val notifications = listOf(
            "You order has been Cancelled Successfully",
            "Order has been taken by the driver",
            "Congrats Your Order Placed",
            "You order has been Cancelled Successfully",
            "Order has been taken by the driver",
            "Congrats Your Order Placed"
        )
        val notificationsImage = listOf(
            R.drawable.sademoji,
            R.drawable.icon,
            R.drawable.illustration,
            R.drawable.sademoji,
            R.drawable.icon,
            R.drawable.illustration
        )
        val adapter = NotificationAdapter(
            ArrayList(notifications),
            ArrayList(notificationsImage),
        )

        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}