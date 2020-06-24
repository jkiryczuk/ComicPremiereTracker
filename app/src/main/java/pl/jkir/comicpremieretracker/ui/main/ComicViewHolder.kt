package pl.jkir.comicpremieretracker.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.jkir.comicpremieretracker.R
import pl.jkir.comicpremieretracker.data.Comic

class ComicViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.premiere_list_item, parent, false)) {
    private var title: TextView? = null

    init {
        title = itemView.findViewById(R.id.list_title)
    }

    fun bind(comic: Comic) {
        title?.text = comic.title
    }

}
