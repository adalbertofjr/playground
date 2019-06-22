package br.com.adalbertofjr.hotel.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.fragment.app.ListFragment
import androidx.lifecycle.Observer
import br.com.adalbertofjr.hotel.R
import br.com.adalbertofjr.hotel.model.Hotel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HotelListFragment : ListFragment(),
    AdapterView.OnItemLongClickListener,
    ActionMode.Callback {
    private val viewModel: HotelListViewModel by sharedViewModel()
    private var actionMode: androidx.appcompat.view.ActionMode? = null


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listView.onItemLongClickListener = this
        viewModel.showDetailsCommand().observe(viewLifecycleOwner, Observer { hotel ->
            if (hotel != null) {
                showHotelDetails(hotel)
            }
        })

        viewModel.isInDeleteMode().observe(viewLifecycleOwner, Observer { deleteMode ->
            if (deleteMode == true) {
                showDeleteMode()
            } else {
                hideDeleteMode()
            }
        })

        viewModel.selectedHotels().observe(viewLifecycleOwner, Observer { hotels ->
            if (hotels != null) {
                showSelectedHotels(hotels)
            }
        })

        viewModel.selectionCount().observe(viewLifecycleOwner, Observer { count ->
            if (count != null) {
                updateSelectionCountText(count)
            }
        })

        viewModel.selectionCount().observe(viewLifecycleOwner, Observer { count ->
            if (count != null) {
                updateSelectionCountText(count)
            }
        })

        viewModel.getHotels()?.observe(viewLifecycleOwner, Observer { hotels ->
            if (hotels != null) {
                showHotels(hotels)
            }
        })

        if (viewModel.getHotels()?.value == null) {
            search()
        }
    }

    fun showHotels(hotels: List<Hotel>) {
        val adapter = HotelAdapter(requireContext(), hotels)
        listAdapter = adapter
    }

    fun showHotelDetails(hotel: Hotel) {
        if (activity is OnHotelClickListener) {
            val listener = activity as OnHotelClickListener
            listener.onHotelClick(hotel)
        }
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        val hotel = l.getItemAtPosition(position) as Hotel
        viewModel.selectHotel(hotel)
    }

    fun search(term: String = "") {
        viewModel.search(term)
    }


    interface OnHotelClickListener {
        fun onHotelClick(hotel: Hotel)
    }

    fun showDeleteMode() {
        val appCompatActivity = (activity as AppCompatActivity)
        actionMode = appCompatActivity.startSupportActionMode(this)
        listView.onItemLongClickListener = null
        listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE
    }

    fun hideDeleteMode() {
        listView.onItemLongClickListener = this

        for (i in 0 until listView.count) {
            listView.setItemChecked(i, false)
        }

        listView.post {
            actionMode?.finish()
            listView.choiceMode = ListView.CHOICE_MODE_NONE
        }
    }

    private fun showSelectedHotels(hotels: List<Hotel>) {
        listView.post {
            for (i in 0 until listView.count) {
                val hotel = listView.getItemAtPosition(i) as Hotel

                if (hotels.find { it.id == hotel.id } != null) {
                    listView.setItemChecked(i, true)
                }
            }
        }
    }

    private fun updateSelectionCountText(count: Int) {
        view?.post {
            actionMode?.title = resources.getQuantityString(R.plurals.list_hotel_selected, count, count)
        }
    }

    override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
        val consumed = (actionMode == null)
        if (consumed) {
            val hotel = parent?.getItemAtPosition(position) as Hotel
            viewModel.setInDeleteMode(true)
            viewModel.selectHotel(hotel)
        }

        return consumed
    }

    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_delete) {
            viewModel.deleteSelected()
            return true
        }
        return false
    }

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        activity?.menuInflater?.inflate(R.menu.hotel_delete_list, menu)
        return true
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?) = false

    override fun onDestroyActionMode(mode: ActionMode?) {
        actionMode = null
        viewModel.setInDeleteMode(false)
    }

    fun showMessageHotelsDeleted(count: Int) {
        Snackbar.make(listView, getString(R.string.message_hotels_deleted, count), Snackbar.LENGTH_LONG)
            .setAction(R.string.undo) {
                viewModel.undoDelete()
            }.show()
    }
}