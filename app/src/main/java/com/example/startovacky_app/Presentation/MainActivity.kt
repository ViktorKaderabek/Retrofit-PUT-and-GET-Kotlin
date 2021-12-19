package com.example.startovacky_app.Presentation

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.startovacky_app.Presentation.ViewModels.MainViewModel
import com.example.startovacky_app.R
import com.example.startovacky_app.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel =
            ViewModelProvider(this, defaultViewModelProviderFactory).get(MainViewModel::class.java)


        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = mainViewModel.fastAdapter
        binding.recyclerview.setHasFixedSize(true)

        CoroutineScope(Dispatchers.IO).launch {
            mainViewModel.loadItems()

        }
        binding.btnNote.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                mainViewModel.createData()
                mainViewModel.loadItems()
            }
            Toast.makeText(applicationContext, "Data Inserted", LENGTH_LONG).show()

        }


        binding.btnAbc.setBackgroundColor(Color.parseColor("#bdbdbd"))
        binding.btnLetovo.setTextColor(Color.parseColor("#3da142"))
        binding.btnNejblize.setBackgroundColor(Color.WHITE)
        binding.btnLetovo.setBackgroundColor(Color.WHITE)
        binding.btnZeme.setBackgroundColor(Color.WHITE)
        binding.cardViewAbc.cardElevation = 10F
        binding.cardViewNejblize.cardElevation = 0F
        binding.cardViewLetovo.cardElevation = 0F
        binding.cardViewZeme.cardElevation = 0F

        binding.btnMista.setBackgroundColor(Color.RED)
        binding.btnMista.setTextColor(Color.WHITE)
        binding.btnStartovacky.setBackgroundColor(Color.WHITE)
        binding.btnStartovacky.setTextColor(Color.BLACK)
        binding.cardViewStartovacky.cardElevation = 10F
        binding.cardViewMista.cardElevation = 0F

        binding.btnMista.setOnClickListener {

            binding.btnMista.setBackgroundColor(Color.RED)
            binding.btnMista.setTextColor(Color.WHITE)
            binding.btnStartovacky.setBackgroundColor(Color.WHITE)
            binding.btnStartovacky.setTextColor(Color.BLACK)
            binding.cardViewStartovacky.cardElevation = 10F
            binding.cardViewMista.cardElevation = 0F
        }
        binding.btnStartovacky.setOnClickListener {

            binding.btnStartovacky.setBackgroundColor(Color.RED)
            binding.btnStartovacky.setTextColor(Color.WHITE)
            binding.btnMista.setBackgroundColor(Color.WHITE)
            binding.btnMista.setTextColor(Color.BLACK)
            binding.cardViewStartovacky.cardElevation = 0F
            binding.cardViewMista.cardElevation = 10F
        }
        binding.btnAbc.setOnClickListener {

            binding.btnAbc.setBackgroundColor(Color.parseColor("#bdbdbd"))
            binding.btnLetovo.setTextColor(Color.parseColor("#3da142"))
            binding.btnNejblize.setBackgroundColor(Color.WHITE)
            binding.btnLetovo.setBackgroundColor(Color.WHITE)
            binding.btnZeme.setBackgroundColor(Color.WHITE)
            binding.cardViewAbc.cardElevation = 10F
            binding.cardViewNejblize.cardElevation = 0F
            binding.cardViewLetovo.cardElevation = 0F
            binding.cardViewZeme.cardElevation = 0F
        }
        binding.btnNejblize.setOnClickListener {

            binding.btnAbc.setBackgroundColor(Color.WHITE)
            binding.btnNejblize.setBackgroundColor(Color.parseColor("#bdbdbd"))
            binding.btnLetovo.setBackgroundColor(Color.WHITE)
            binding.btnLetovo.setTextColor(Color.parseColor("#3da142"))
            binding.btnZeme.setBackgroundColor(Color.WHITE)
            binding.cardViewAbc.cardElevation = 0F
            binding.cardViewNejblize.cardElevation = 10F
            binding.cardViewLetovo.cardElevation = 0F
            binding.cardViewZeme.cardElevation = 0F
        }
        binding.btnLetovo.setOnClickListener {

            binding.btnAbc.setBackgroundColor(Color.WHITE)
            binding.btnNejblize.setBackgroundColor(Color.WHITE)
            binding.btnLetovo.setBackgroundColor(Color.parseColor("#3da142"))
            binding.btnLetovo.setTextColor(Color.parseColor("#3da142"))
            binding.btnZeme.setBackgroundColor(Color.WHITE)
            binding.cardViewAbc.cardElevation = 0F
            binding.cardViewNejblize.cardElevation = 0F
            binding.cardViewLetovo.cardElevation = 10F
            binding.cardViewZeme.cardElevation = 0F
        }
        binding.btnZeme.setOnClickListener {

            binding.btnAbc.setBackgroundColor(Color.WHITE)
            binding.btnNejblize.setBackgroundColor(Color.WHITE)
            binding.btnLetovo.setBackgroundColor(Color.WHITE)
            binding.btnLetovo.setTextColor(Color.parseColor("#3da142"))
            binding.btnZeme.setBackgroundColor(Color.parseColor("#bdbdbd"))
            binding.cardViewAbc.cardElevation = 0F
            binding.cardViewNejblize.cardElevation = 0F
            binding.cardViewLetovo.cardElevation = 0F
            binding.cardViewZeme.cardElevation = 10F
        }
    }

}
