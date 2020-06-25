package pl.jkir.comicpremieretracker.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pl.jkir.comicpremieretracker.data.Comic
import pl.jkir.comicpremieretracker.data.ComicResponse
import pl.jkir.comicpremieretracker.utils.ShortBoxApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Logger
import kotlin.math.log

class PageViewModel : ViewModel() {

    private val failureMessage = "Failure to connect in fetchDataMethod()"
    private val emptyResponseMessage = "Empty response in fetchDataMethod()"
    private val nullResponseContentMessage = "Null response in fetchDataMethod()"
    private var comicBookList = MutableLiveData<ComicResponse>()

    fun getList(): MutableLiveData<ComicResponse> {
        return comicBookList
    }

    private fun fetchData() {
        val shortBoxApiService = ShortBoxApiService.Factory.create()
        val call = shortBoxApiService.getNew()
        call.enqueue(object : Callback<ComicResponse> {
            override fun onFailure(call: Call<ComicResponse>, t: Throwable) {
                Log.e(javaClass.name, failureMessage, t.cause)
            }

            override fun onResponse(call: Call<ComicResponse>, response: Response<ComicResponse>) {
                if (response.body() == null) {
                    Log.e(javaClass.name, emptyResponseMessage)
                } else if (response.body()!!.comics.isNullOrEmpty()) {
                    Log.e(javaClass.name, nullResponseContentMessage)
                } else {
                    Log.d(javaClass.name, response.body().toString())
                    comicBookList.value = response.body()!!
                }
            }

        })
    }

    fun callApi() {
        this.fetchData()
    }

}