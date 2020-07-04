package pl.jkir.comicpremieretracker.ui.main.newcomiclist

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.jkir.comicpremieretracker.MainActivity
import pl.jkir.comicpremieretracker.R
import pl.jkir.comicpremieretracker.data.Comic
import java.util.regex.Pattern

class ComicViewHolder(inflater: LayoutInflater, parent: ViewGroup, context: Context) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.premiere_list_item, parent, false)) {
    private var title: TextView? = null
    private var price: TextView? = null
    private var creators: TextView? = null
    private var releaseDate: TextView? = null
    private var cover: ImageView? = null
    private var fragmentContext: Context
    private val imageServer = ""

    init {
        title = itemView.findViewById(R.id.list_title)
        price = itemView.findViewById(R.id.list_price)
        creators = itemView.findViewById(R.id.list_creators)
        releaseDate = itemView.findViewById(R.id.list_release_date)
        cover = itemView.findViewById(R.id.comic_cover)
        fragmentContext = context
    }

    fun bind(comic: Comic) {
        title?.text = comic.title.capitalize()
        price?.text = comic.price
        releaseDate?.text = comic.release_date
        var temp = ""
        var arr = comic.creators.split(" [(].*?[)] |[(].*?[)] ".toRegex())
        Log.d(javaClass.name, arr.toString())
        for (creator in arr) {
            Log.d(javaClass.name, creator.toString())
            if (!creator.isEmpty()) {
                temp += creator + "; "
            }
        }
        creators?.text = temp
        cover?.let {
            Glide.with(this.fragmentContext).load(
                String.format(
                    imageServer, comic.diamond_id
                )
            )
                .into(it)
        };
    }

}
