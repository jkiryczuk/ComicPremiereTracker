package pl.jkir.comicpremieretracker.ui.main.newcomiclist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.jkir.comicpremieretracker.R
import pl.jkir.comicpremieretracker.data.Comic
import java.util.regex.Pattern

class ComicViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.premiere_list_item, parent, false)) {
    private var title: TextView? = null
    private var price: TextView? = null
    private var creators: TextView? = null
    private var releaseDate: TextView? = null

    init {
        title = itemView.findViewById(R.id.list_title)
        price = itemView.findViewById(R.id.list_price)
        creators = itemView.findViewById(R.id.list_creators)
        releaseDate = itemView.findViewById(R.id.list_release_date)
    }

    fun bind(comic: Comic) {
        title?.text = comic.title.capitalize()
        price?.text = comic.price
        releaseDate?.text = comic.release_date
        var temp = ""
        var arr = comic.creators.split(" [(].*?[)] |[(].*?[)] ".toRegex())
        Log.d(javaClass.name, arr.toString())
        for(creator in arr) {
            Log.d(javaClass.name,creator.toString())
            if (!creator.isEmpty()) {
                temp += creator + "; "
            }
        }
        creators?.text = temp
    }

}
