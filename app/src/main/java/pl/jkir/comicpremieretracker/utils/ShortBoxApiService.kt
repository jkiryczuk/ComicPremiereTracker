package pl.jkir.comicpremieretracker.utils

import pl.jkir.comicpremieretracker.data.ComicResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ShortBoxApiService {

    @GET("new")
    fun getNew(): Call<ComicResponse>

    companion object Factory {
        const val BASE_URL = "https://api.shortboxed.com/comics/v1/"

        fun create(): ShortBoxApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(this.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ShortBoxApiService::class.java)
        }

    }
}