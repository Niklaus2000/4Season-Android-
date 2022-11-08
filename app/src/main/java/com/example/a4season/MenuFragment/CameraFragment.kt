package com.example.a4season.MenuFragment


import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.a4season.databinding.FragmentCameraBinding



class CameraFragment: Fragment() {
    private var fragmentCameraBinding: FragmentCameraBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(inflater: LayoutInflater , container: ViewGroup? , savedInstanceState: Bundle?): View {
        val binding = FragmentCameraBinding.inflate(inflater , container , false)
        fragmentCameraBinding = binding





        if (ActivityCompat.checkSelfPermission(requireContext() ,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireContext() as Activity , arrayOf(Manifest.permission.CAMERA) , 111)

        } else

            binding.cameraButton.isEnabled = true

        binding.cameraButton.setOnClickListener {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                resultLauncher.launch(cameraIntent)

            }






        return binding.root

    }




    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
              handleCameraImage(result.data)

            }
        }
    private fun handleCameraImage(intent: Intent?) {
        var bitmap = intent?.extras?.get("data") as Bitmap




    }

    override fun onRequestPermissionsResult(requestCode: Int , permissions: Array<out String> , grantResults: IntArray) {
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                fragmentCameraBinding!!.cameraButton.isEnabled = true

            }
        }
    }
}






