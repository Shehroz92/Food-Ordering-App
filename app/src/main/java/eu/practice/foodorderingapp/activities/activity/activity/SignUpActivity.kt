package eu.practice.foodorderingapp.activities.activity.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import eu.practice.foodorderingapp.activities.activity.models.UserModel
import eu.practice.foodorderingapp.databinding.ActivitySigUpBinding



class SignUpActivity : AppCompatActivity() {

    private lateinit var email:String
    private lateinit var password:String
    private lateinit var username:String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference
    private lateinit var googleSignInClient: GoogleSignInAccount

    private val binding : ActivitySigUpBinding by lazy {
        ActivitySigUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // initialize Firebase auth
        auth = Firebase.auth
        // initialize Firebase database
        FirebaseApp.initializeApp(this)
        database = FirebaseDatabase.getInstance().reference



        binding.alreadyHaveAnAccount.setOnClickListener{
            val intent = Intent (this@SignUpActivity , LoginActivity::class.java )
            startActivity(intent)
            finish()
        }

        binding.buttonCreatAccount.setOnClickListener{

            username = binding.nameuser.text.toString()
            email = binding.emailOrphone.text.toString().trim()
            password = binding.password.text.toString().trim()

            if (username.isBlank() || email.isBlank() || password.isBlank()){
                Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show()
            }else{
                createAccount(email,password)
            }
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            task ->
            if (task.isSuccessful){
                           Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show()
                           saveUserData()
                           startActivity(Intent(this,LoginActivity::class.java))
                           finish()
            }else{
                Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_SHORT).show()
                Log.d("Account","create Account : Failure",task.exception)
            }
        }
    }

    private fun saveUserData() {
        // retrieve data from input field
        username = binding.nameuser.text.toString()
        email = binding.emailOrphone.text.toString().trim()
        password = binding.password.text.toString().trim()

        val user = UserModel(username,email,password)
        val userId:String = FirebaseAuth.getInstance().currentUser!!.uid
        // save data to fire base data base
        database.child("account").child(userId).setValue(user)

    }
}
