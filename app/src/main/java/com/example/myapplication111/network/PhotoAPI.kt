package com.example.myapplication111.network

import com.example.myapplication111.constants.Constants
import com.example.myapplication111.model.PhotoResponse
import com.example.myapplication111.model.PhotoResponseItem
import com.example.myapplication111.model.character
import com.example.myapplication111.model.characterItem
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface PhotoAPI {

    @GET(Constants.END_POINT)
    suspend fun getPhoto(
    ): PhotoResponse

}