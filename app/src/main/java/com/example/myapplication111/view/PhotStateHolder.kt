package com.example.myapplication111.view

import com.example.myapplication111.model.PhotoResponse
import com.example.myapplication111.model.PhotoResponseItem
import com.example.myapplication111.model.characterItem

data class PhotoStateHolder(

    val isLoading: Boolean =false,
    val data: List<PhotoResponseItem>?=null,
    val error: String =""
)
