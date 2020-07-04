package pl.jkir.comicpremieretracker.ui.main.watchlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.watchlist_fragment.*
import pl.jkir.comicpremieretracker.R

class WatchlistFragment : Fragment() {

    companion object {
        fun newInstance() =
            WatchlistFragment()
    }

    private lateinit var viewModel: WatchlistViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.watchlist_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WatchlistViewModel::class.java)
        watchlistmessage.text = viewModel.getMessage()
    }


}