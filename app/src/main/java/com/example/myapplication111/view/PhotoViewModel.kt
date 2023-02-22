package com.example.myapplication111.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication111.data.Resource
import com.example.myapplication111.repo.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PhotoViewModel @Inject constructor(private val repository: PhotoRepository): ViewModel() {

    val photoList= mutableStateOf(PhotoStateHolder())



    init {
        photoList.value= PhotoStateHolder(isLoading = true)
        getPhotos()
    }

    private fun getPhotos()=viewModelScope.launch(Dispatchers.IO) {

        when(val result=repository.getPhotos()){

            is Resource.Success ->{

                photoList.value= PhotoStateHolder(data = result.data)
            }
            is Resource.Error ->{
                photoList.value=PhotoStateHolder(error = result.message.toString())
            }
            else ->{

            }
        }
    }



}