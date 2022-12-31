package com.example.github.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github.data.GResponse
import com.example.github.repo.Repository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Response

class GithubViewModel:ViewModel() {
    private val livedata= MutableLiveData<Response<GResponse>>()
    val list:LiveData<Response<GResponse>>
    get() = livedata


 fun Everything(){
       viewModelScope.launch(Dispatchers.IO) {
             val result= Repository.getEverything()
             if(result.code()==200){
                 livedata.postValue(result)
             }
        }
    }


}