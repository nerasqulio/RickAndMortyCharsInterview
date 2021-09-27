package com.example.RickAndMortyChars.App.Networking

import com.example.RickAndMortyChars.App.ResponseDataStructure.GetCharIDResponse
import java.io.IOException

class SharedRepository {



    suspend fun getCharByPage(charID : String) : List<GetCharIDResponse>?
    {
        val request2 = Networking.apiclient.getCharByPage(charID)
        if(!request2.isSuccessful)
        {

            return null
        }
        else
        {
            return request2.body()
        }
    }

}
