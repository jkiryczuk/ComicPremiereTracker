package pl.jkir.comicpremieretracker.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.jkir.comicpremieretracker.data.Comic
import pl.jkir.comicpremieretracker.ui.main.ComicViewHolder

class PremiereListAdapter(private var list: ArrayList<Comic>) : RecyclerView.Adapter<ComicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ComicViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val comic: Comic = list[position]
        holder.bind(comic)
    }

    fun setItems(comics : ArrayList<Comic>) {
        list.clear()
        list = comics
        notifyDataSetChanged()
    }

}
