package com.example.weatherapplication.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.SearchOptionBinding
import com.example.weatherapplication.view.SearchView

class CustomAdapter(private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(private val itemBinding: SearchOptionBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: String){
            itemBinding.locationText.text = data
            itemBinding.root.animation = AnimationUtils.loadAnimation(itemBinding.root.context, R.anim.scrolldown_anim)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        /*val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.search_option, viewGroup, false)*/
        val view = SearchOptionBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.bind(dataSet[position])

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
