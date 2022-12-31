package com.example.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github.data.GResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class GithubViewModel:ViewModel() {
    private val livedata= MutableLiveData<Response<GResponse>>()
    val list:LiveData<Response<GResponse>>
    get() = livedata


    fun Everything(){
        GlobalScope.launch(Dispatchers.IO) {
             val result=Repository.getEverything()
             if(result.code()==200){
                 livedata.postValue(result)
             }
        }
    }


}