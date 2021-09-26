package com.example.rickandmortychars

import retrofit2.Call
import retrofit2.Response

class Client(val RNMService : Service)
{


    suspend fun getCharByPage(charID : String) : Response<List<GetCharIDResponse>> {
        return RNMService.getCharByPage(charID)
    }
}
