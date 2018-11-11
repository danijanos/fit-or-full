package hu.uniobuda.nik.fitorfull.Adapters

import android.support.v7.widget.RecyclerView
import android.widget.TextView
import hu.uniobuda.nik.fitorfull.Models.Restaurant

class RestaurantListAdapter(
        private val restaurantList: Array<Restaurant>
) : RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(val restaurantView: TextView)
        : RecyclerView.ViewHolder(restaurantView)

}