package pl.jkir.comicpremieretracker.ui.main.newcomiclist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import pl.jkir.comicpremieretracker.R
import pl.jkir.comicpremieretracker.data.Comic
import pl.jkir.comicpremieretracker.data.ComicResponse

/**
 * A placeholder fragment containing a simple view.
 */
class PremiereListFragment : Fragment() {

    private lateinit var viewModel: PageViewModel
    private lateinit var comicsAdapter: PremiereListAdapter
    private var comics = ArrayList<Comic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PageViewModel::class.java)
        defineObserver(viewModel)
    }

    private fun defineObserver(viewModel: PageViewModel) {
        viewModel.getList().observe(this, Observer<ComicResponse> {
            if (!it.comics.isNullOrEmpty()) {
                Log.d(javaClass.name, "Data Changed")
                comics = it.comics
                comicsAdapter.setItems(comics)
            } else {
                Log.e(javaClass.name, "Null")
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comicsAdapter =
            PremiereListAdapter(
                comics
            )
        premiere_list.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = comicsAdapter
        }
        viewModel.callApi()
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): PremiereListFragment {
            return PremiereListFragment()
                .apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}