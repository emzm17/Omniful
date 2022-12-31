package com.example.github

import com.example.github.api.RetrofitHelper

object Repository {

   suspend fun getEverything()=RetrofitHelper.api.getEverything()
}