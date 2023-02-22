package com.example.myapplication111.view

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myapplication111.model.PhotoResponseItem


@Composable
fun photoListScreen(viewModel: PhotoViewModel= hiltViewModel()) {

    val result = viewModel.photoList.value

    if (result.isLoading) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()

        }

    }

    if (result.error.isNotBlank()) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = result.error)
        }

    }
    result.data?.let {

        LazyColumn{
                items(result.data){
                    PhotoItem(it)
                }
        }
    }

}

@Composable
fun PhotoItem(it: PhotoResponseItem) {


    AsyncImage(model = it.url, contentDescription =null, modifier = Modifier.fillMaxWidth().height(220.dp).padding(vertical = 4.dp), contentScale = ContentScale.Crop )

}








