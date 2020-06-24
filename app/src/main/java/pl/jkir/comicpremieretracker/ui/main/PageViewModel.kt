package pl.jkir.comicpremieretracker.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pl.jkir.comicpremieretracker.data.Comic

class PageViewModel : ViewModel() {

    private val mockupComicList = listOf(
        Comic("Batman"),
        Comic("Spiderman"),
        Comic("Justice League"),
        Comic("Avengers"),
        Comic("X-Men"),
        Comic("Green Arrow"),
        Comic("Smurfs"),
        Comic("Fables")
    )

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Hello world from section: $it"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }

    fun getMockup(): List<Comic> {
        return mockupComicList
    }
}