package com.example.rickandmortychars

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
