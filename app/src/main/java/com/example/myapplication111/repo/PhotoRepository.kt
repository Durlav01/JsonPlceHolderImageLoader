package com.example.myapplication111.repo

import com.example.myapplication111.data.Resource
import com.example.myapplication111.model.PhotoResponse
import com.example.myapplication111.model.PhotoResponseItem
import com.example.myapplication111.model.characterItem
import com.example.myapplication111.network.PhotoAPI
import javax.inject.Inject

class PhotoRepository @Inject constructor(private val api: PhotoAPI) {



    suspend fun getPhotos(): Resource<List<PhotoResponseItem>> {

        return try {

            Resource.Success(data = api.getPhoto())

        }catch (e: Exception){

            Resource.Error(message = e.message.toString())


        }

    }
}
