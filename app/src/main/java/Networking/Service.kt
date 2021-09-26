package Networking

import ResponseDataStructure.GetCharIDResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface Service {


    @GET("character/{charID}")
    suspend fun getCharByPage(@Path("charID") charID : String): Response<List<GetCharIDResponse>>



}