package com.example.startovacky_app.Presentation

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
        binding.floatingActionButton.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                mainViewModel.createData()
                mainViewModel.loadItems()
            }
            Toast.makeText(applicationContext, "Data Inserted", LENGTH_LONG).show()

        }

    }
}