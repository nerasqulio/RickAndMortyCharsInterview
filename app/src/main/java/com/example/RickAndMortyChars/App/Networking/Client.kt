package com.example.RickAndMortyChars.App.Networking
import com.example.RickAndMortyChars.App.ResponseDataStructure.GetCharIDResponse
import retrofit2.Response


class Client(val RNMService : Service)
{
    suspend fun getCharByPage(charID : String) : HandledResponse<List<GetCharIDResponse>> {


        return  handleResponse{RNMService.getCharByPage(charID)}
    }

    inline fun <T> handleResponse (handle : () -> Response<T>) : HandledResponse<T>
    {
        return try{

            HandledResponse.isSuccess(handle())

        }catch (e : Exception)
        {
            return HandledResponse(null)
        }

    }
}
