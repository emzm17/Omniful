package com.example.github.api

import androidx.lifecycle.LiveData
import com.example.github.data.GResponse
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("search/repositories?q=%22%22+language:kotlin&pushed:%2022-12-20&sort=stars&order=desc")
   suspend fun getEverything(): Response<GResponse>

}