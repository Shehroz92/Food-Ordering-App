package eu.practice.foodorderingapp.activities.activity.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import eu.practice.foodorderingapp.activities.activity.activity.LoginActivity
import eu.practice.foodorderingapp.activities.activity.models.UserModel
import eu.practice.foodorderingapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {


    private lateinit var binding: FragmentProfileBinding
    private val auth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(layoutInflater)
        binding.logOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent  = Intent(requireContext(),LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }


        setUserData()
        binding.saveInfoButton.setOnClickListener {
            val name = binding.ProfileName.text.toString()
            val email = binding.profileEmail.text.toString()
            val address = binding.ProfileAddress.text.toString()
            val phone = binding.ProfilePhone.text.toString()

            updateUserData(name, email, address, phone)


        }
        binding.apply {
            ProfileName.isEnabled = false
            ProfileAddress.isEnabled = false
            ProfilePhone.isEnabled = false
            profileEmail.isEnabled = false


            binding.editProfile.setOnClickListener {

                ProfileName.isEnabled = !ProfileName.isEnabled
                ProfileAddress.isEnabled = !ProfileAddress.isEnabled
                ProfilePhone.isEnabled = !ProfilePhone.isEnabled
                profileEmail.isEnabled = !profileEmail.isEnabled

            }
        }

        return binding.root
    }

    private fun updateUserData(name: String, email: String, address: String, phone: String) {
        val userId = auth.currentUser?.uid
        if (userId != null) {
            val userReference = database.getReference("user").child(userId)
            val userData = hashMapOf(
                "name" to name,
                "address" to address,
                "email" to email,
                "phone" to phone

            )
            userReference.setValue(userData).addOnSuccessListener {
                Toast.makeText(requireContext(), "Profile Update Successfully ", Toast.LENGTH_SHORT)
                    .show()
            }.addOnFailureListener {
                Toast.makeText(requireContext(), "Profile Not Update", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun setUserData() {
        val userId = auth.currentUser?.uid ?: ""
        if (userId != null) {
            val userReference = database.getReference("user").child(userId)
            userReference.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val userProfile = snapshot.getValue(UserModel::class.java)
                        if (userProfile != null) {

                            binding.ProfileName.setText(userProfile.name)
                            binding.ProfileAddress.setText(userProfile.address)
                            binding.profileEmail.setText(userProfile.email)
                            binding.ProfilePhone.setText(userProfile.phone)

                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        }

    }
}