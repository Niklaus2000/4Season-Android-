package com.example.a4season

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.a4season.adapter.OnBoardingItemsAdapter
import com.example.a4season.databinding.ActvityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActvityMainBinding
    private lateinit var onBoardingItemsAdapter: OnBoardingItemsAdapter
    private lateinit var indicatorsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActvityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setOnBoardingItems()
        setUpIndicators()
        setCurrentIndicator(0)

    }
    private fun setOnBoardingItems() {
         onBoardingItemsAdapter = OnBoardingItemsAdapter(
             listOf(
                 OnBoardingItem(
                     onBoardingImage = R.mipmap.picture1,
                     title = "sdafs",
                     description = "dsad"
                 ),
                 OnBoardingItem(
                     onBoardingImage = R.mipmap.picture2,
                     title = "sdafs",
                     description = "dsad"
                 ), OnBoardingItem(
                     onBoardingImage = R.mipmap.picture3,
                     title = "sdafs",
                     description = "dsad"
                 )
             )
         )
        val onBoardingViewPager = binding.onBoardingViewPager
        onBoardingViewPager.adapter = onBoardingItemsAdapter
        onBoardingViewPager.registerOnPageChangeCallback(object :
        ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (onBoardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
        binding.imageNext.setOnClickListener {
              if (onBoardingViewPager.currentItem + 1 < onBoardingItemsAdapter.itemCount) {
                  onBoardingViewPager.currentItem += 1
              }else {
                  navigateToLoginAndRegister()
              }
        }
        binding.textSkip.setOnClickListener{
            navigateToLoginAndRegister()
        }
        binding.buttonGetStarted.setOnClickListener {
            navigateToLoginAndRegister()
        }
    }
    private fun navigateToLoginAndRegister() {
        startActivity(Intent(applicationContext,Loginandregister::class.java))
        finish()
    }
    private fun setUpIndicators() {
        indicatorsContainer = findViewById(R.id.indicatorsContainer)
        val indicators = arrayOfNulls<ImageView>(onBoardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams = layoutParams
                indicatorsContainer.addView(it)

            }
        }
    }
    private fun setCurrentIndicator(position: Int) {
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount) {
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            }else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }
}