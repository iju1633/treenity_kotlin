package com.example.treenity_kotlin.ui.store

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.treenity_kotlin.data.model.ImageItem
import com.example.treenity_kotlin.data.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel
@Inject
constructor(private val repository: ImageRepository) : ViewModel() {

    private val _response = MutableLiveData<List<ImageItem>>()

    val responseImages:LiveData<List<ImageItem>>
        get()= _response

    init {
        getAllImages()
    }

    private fun getAllImages() = viewModelScope.launch(Dispatchers.IO){

        repository.getAllImages().let { response ->

            if(response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("your tag", "getAllImages Error: ${response.errorBody()}")
            }
            // 나중에 TAG companion object로 constant 처리 부탁드려요
        }

    }

}