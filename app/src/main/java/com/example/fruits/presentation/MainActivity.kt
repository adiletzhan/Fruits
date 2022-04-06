package com.example.fruits.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruits.R
import com.example.fruits.databinding.ActivityMainBinding
import com.example.fruits.databinding.ItemFruitBinding
import com.example.fruits.domain.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOException

const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var fruitsAdapter: FruitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true

            val response = try {
                RetrofitInstance.api.getAllFruits()
            } catch (e: IOException){
                Log.e(TAG, "IOException, you might not have internet connection")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response")
                return@launchWhenCreated
            }
        }
    }

    private fun setupRecyclerView() = binding.rvFruits.apply {
        fruitsAdapter = FruitAdapter()
        adapter = fruitsAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}