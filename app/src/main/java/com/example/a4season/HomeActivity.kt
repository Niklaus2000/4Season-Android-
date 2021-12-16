package com.example.a4season

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.a4season.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        toggle = ActionBarDrawerToggle(this,binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener {


            when(it.itemId){
                R.id.camera -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()
                R.id.flyticket -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()
                R.id.hotel -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()
                R.id.memories -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()
                R.id.tax -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()
                R.id.weather -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()
                R.id.signout -> Toast.makeText(applicationContext,"clicked",Toast.LENGTH_SHORT).show()


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

}