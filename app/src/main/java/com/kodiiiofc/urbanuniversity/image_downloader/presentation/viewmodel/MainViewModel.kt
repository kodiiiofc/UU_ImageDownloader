package com.kodiiiofc.urbanuniversity.image_downloader.presentation.viewmodel

import android.graphics.drawable.Drawable
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.kodiiiofc.urbanuniversity.image_downloader.domain.models.utils.RetrofitInstance
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MainViewModel : ViewModel() {
    val imageUrl = MutableLiveData<String>()

    init {
        updateDog()
    }

    fun updateDog() =
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.api.getRandomDog()
            } catch (e: IOException) {
                Log.d("EXC", "${e.message}")
                return@launch
            } catch (e: HttpException) {
                Log.d("EXC", "${e.message}")
                return@launch
            }
            val data = response.body()
            if (response.isSuccessful) {
                if (data != null) {
                    imageUrl.value = data.url
                }
            }
        }

}