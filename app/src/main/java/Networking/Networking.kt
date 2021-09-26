package Networking

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Networking {


    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val rtFit : Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    val RNMService : Service by lazy { rtFit.create(Service::class.java)}
    val apiclient = Client(RNMService)

}