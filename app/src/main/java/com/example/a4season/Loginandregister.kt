package com.example.a4season

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a4season.adapter.LoginAdapter
import com.example.a4season.databinding.ActivityLoginandregisterBinding
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth


class  Loginandregister : AppCompatActivity() {
    companion object {
        private const val RC_SIGN_IN = 120

    }
    private lateinit var binding: ActivityLoginandregisterBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginandregisterBinding.inflate(layoutInflater)
        val view = binding.root
        enableTabLayoutMediator()
       // checkUser()
        setContentView(view)


        // Configure Google Sign In
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//
//
//

//        googleSignInClient = GoogleSignIn.getClient(this, gso)
//        mAuth = FirebaseAuth.getInstance()

//        val viewpager = findViewById<ViewPager2>(R.id.view_pager)
//        val tablayout = findViewById<TabLayout>(R.id.tab_layout)


        binding.fabGoogle.setOnClickListener{
//            checkUser()


        }

    }
//    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            val intent = GoogleSignIn.getSignedInAccountFromIntent(intent)
//            try {
//                // Google Sign In was successful, authenticate with Firebas
//
//                val account = intent.getResult(ApiException::class.java)
//                firebaseAuthWithGoogle(account.idToken!!)
//            } catch (e: ApiException) {
//
//            }
//
//        }
//    }
//
//    private fun firebaseAuthWithGoogle(idToken: String) {
//
//    }


//    private fun checkUser() {
//        mAuth = FirebaseAuth.getInstance()
//        val user = mAuth.currentUser
//
//        if (user != null){
//            val homeIntent = Intent(this, HomeActivity::class.java)
//            startActivity(homeIntent)
//        }else {
//            val loginandregisterIntent = Intent(this, Loginandregister::class.java)
//            startActivity(loginandregisterIntent)
//
//        }
//
//    }





    private fun enableTabLayoutMediator() {
        val adapter = LoginAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Login"
                }
                1 -> {
                    tab.text = "Register"
                }
            }
        }.attach()

    }

}



