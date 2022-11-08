package com.example.a4season.MenuFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a4season.MenuFragmentBottom.AutmunFragment
import com.example.a4season.MenuFragmentBottom.SpringFragment
import com.example.a4season.MenuFragmentBottom.SummerFragment
import com.example.a4season.MenuFragmentBottom.WinterFragment
import com.example.a4season.R
import com.example.a4season.databinding.FragmentHotelBinding


class HotelFragment : Fragment() {
    val fragment = SpringFragment()
    private var fragmentHotelBinding: FragmentHotelBinding? = null


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentHotelBinding.inflate(inflater, container, false)
        fragmentHotelBinding = binding
        openMainFragment()


        binding.bottomMenu.setItemSelected(R.id.spring)
        binding.bottomMenu.setOnItemSelectedListener{
            when (it){
                R.id.spring -> {
                    openMainFragment()
                }
                R.id.summer -> {
                    val summerFragment = SummerFragment()
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, summerFragment).commit()
                }
                R.id.autmun -> {
                    val autmunFragment = AutmunFragment()
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, autmunFragment).commit()
                }
                R.id.winter -> {
                    val winterFragment = WinterFragment()
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, winterFragment).commit()
                }
            }
        }
        return binding.root

    }
    private fun openMainFragment() {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.commit()
    }

}





