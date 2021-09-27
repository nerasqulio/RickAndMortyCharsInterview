package com.example.RickAndMortyChars.App.Networking


import com.example.RickAndMortyChars.App.ResponseDataStructure.GetCharIDResponse
import retrofit2.Response

class Client(val RNMService : Service)
{


    suspend fun getCharByPage(charID : String) : Response<List<GetCharIDResponse>> {
        return RNMService.getCharByPage(charID)
    }
}
