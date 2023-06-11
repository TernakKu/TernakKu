package com.dicoding.ternakku.ui.detail

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.TextView
import com.dicoding.ternakku.MainActivity
import com.dicoding.ternakku.R
import com.dicoding.ternakku.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()

        val named = intent.getStringExtra(MainActivity.EXTRA_NAMED)
        val detail = intent.getStringExtra(MainActivity.EXTRA_DETAIL)
        val handleM = intent.getStringExtra(MainActivity.EXTRA_HANDLE)

        val name = findViewById<TextView>(R.id.tv_name)
        val description =  findViewById<TextView>(R.id.tv_description)
        val handle = findViewById<TextView>(R.id.tv_handle)


        name.text = named
        description.text = detail
        handle.text = handleM

    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        setSupportActionBar(binding.appBar)
        binding.appBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}