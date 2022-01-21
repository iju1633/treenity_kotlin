package com.example.treenity_kotlin.ui.store

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.treenity_kotlin.ui.store.adapter.ImageAdapter
import com.example.treenity_kotlin.databinding.ActivityStoreBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoreBinding
    private lateinit var imageAdapter: ImageAdapter

    private val viewModel: ImageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        imageAdapter = ImageAdapter()

        binding.recyclerView.apply {
            adapter = imageAdapter
            layoutManager = LinearLayoutManager(this@StoreActivity)
            setHasFixedSize(true)
        }

        viewModel.responseImages.observe(this, { response ->

            response?.let {
                imageAdapter.submitList(it)
            }
        })
    }

    // go to https://unsplash.com/developers to get the api
}