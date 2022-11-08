package com.example.a4season

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.a4season.MenuFragment.*
import com.example.a4season.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpViews()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)






    }

    private fun setUpViews(){
        setUpDrawerLayout()
    }
    private fun setUpDrawerLayout() {
        setSupportActionBar(binding.topAppBar)
        toggle = ActionBarDrawerToggle(this,binding.drawerLayout,R.string.open,R.string.open)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener {

            it.isChecked = true


            when(it.itemId){
//                R.id.camera -> replaceFragment(CameraFragment(),it.title.toString())
                R.id.camera -> replaceFragment(CameraFragment(), it.title.toString())
                R.id.signout -> replaceFragment(ExitFragment(), it.title.toString())
                R.id.hotel -> replaceFragment(HotelFragment(),it.title.toString())
                R.id.flyticket -> replaceFragment(FlyTicketFragment(),it.title.toString())
                R.id.memories -> replaceFragment(MemoriesFragment(),it.title.toString())
                R.id.tax -> replaceFragment(TaxFragment(),it.title.toString())
                R.id.wallet -> replaceFragment(WalletFragment(),it.title.toString())
                R.id.weather -> replaceFragment(WeatherFragment(),it.title.toString())
//                id.flyticket -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()
//                id.hotel -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()
//                id.memories -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()
//                id.tax -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()
//                id.weather -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()
//                id.signout -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()


            }
            true
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment, title: String){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
        binding.drawerLayout.closeDrawers()
        setTitle(title)

    }





}