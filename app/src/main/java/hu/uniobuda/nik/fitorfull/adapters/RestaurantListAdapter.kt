package hu.uniobuda.nik.fitorfull.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import hu.uniobuda.nik.fitorfull.models.Restaurant
import hu.uniobuda.nik.fitorfull.R

class RestaurantListAdapter(
        private val restaurantList: Array<Restaurant>
) : RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(val restaurantView: TextView)
        : RecyclerView.ViewHolder(restaurantView)

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int): RestaurantListAdapter.RestaurantViewHolder {

        val restaurantView = LayoutInflater.from(parent.context)
                .inflate(R.layout.restaurant_view, parent, false) as TextView

        return RestaurantViewHolder(restaurantView)
    }

    override fun onBindViewHolder(
            holder: RestaurantViewHolder,
            position: Int) {

        holder.restaurantView.text = restaurantList[position].name
    }

    // invoked by the layout manager
    override fun getItemCount() = restaurantList.size
}