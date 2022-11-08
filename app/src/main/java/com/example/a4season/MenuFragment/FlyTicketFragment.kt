package com.example.a4season.MenuFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a4season.databinding.FragmentFlyTicketBinding


class FlyTicketFragment : Fragment() {
    private var fragmentFlyTicketBinding: FragmentFlyTicketBinding? = null


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(inflater: LayoutInflater , container: ViewGroup? , savedInstanceState: Bundle?): View {
        val binding = FragmentFlyTicketBinding.inflate(inflater , container , false)
        fragmentFlyTicketBinding = binding




            return binding.root
    }
}
