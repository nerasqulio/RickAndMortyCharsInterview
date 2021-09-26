package com.example.rickandmortychars

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class Model : ViewModel() {
    val repository = SharedRepository()

    val charByPageMutableLive = MutableLiveData<List<GetCharIDResponse>>()
    val charByPageLive: LiveData<List<GetCharIDResponse>?> = charByPageMutableLive


    fun updateCharPage(charID : String)
    {
        viewModelScope.launch {
            var response = repository.getCharByPage(charID)
            charByPageMutableLive.postValue(response)
        }
    }
}