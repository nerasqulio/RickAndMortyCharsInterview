package Networking


import ResponseDataStructure.GetCharIDResponse
import retrofit2.Response

class Client(val RNMService : Service)
{


    suspend fun getCharByPage(charID : String) : Response<List<GetCharIDResponse>> {
        return RNMService.getCharByPage(charID)
    }
}
