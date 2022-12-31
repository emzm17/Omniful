package com.example.github.repo

import com.example.github.api.RetrofitHelper

object Repository {

   suspend fun getEverything()=RetrofitHelper.api.getEverything()
}