package com.example.a4season.LoginAndRegisterFragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a4season.HomeActivity
import com.example.a4season.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var fragmentDemoBinding: FragmentLoginBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        fragmentDemoBinding = binding

        binding.loginButton.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }
}
