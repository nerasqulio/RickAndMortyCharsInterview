package com.example.RickAndMortyChars.App.Networking

import android.util.Log
import retrofit2.Response
import javax.net.ssl.HandshakeCompletedEvent

data class HandledResponse<T>(
    val data: Response<T>?,

) {
    companion object {

        fun <T> isSuccess(data: Response<T>): HandledResponse<T> {
            return HandledResponse(data = data)
        }
}
    fun check() : Boolean
    {
        return data == null
    }
    fun retBareResponse() : T?
    {
        return data?.body()

    }


}
