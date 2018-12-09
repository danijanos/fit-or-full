package hu.uniobuda.nik.fitorfull.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hu.uniobuda.nik.fitorfull.models.Restaurant
import hu.uniobuda.nik.fitorfull.R
import kotlinx.android.synthetic.main.restaurant_view.view.*

class RestaurantListAdapter(
        private val restaurantList: Array<Restaurant>
) : RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(val restaurantView: View)
        : RecyclerView.ViewHolder(restaurantView)

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int): RestaurantListAdapter.RestaurantViewHolder {

        val restaurantView = LayoutInflater.from(
                parent.context)
                .inflate(R.layout.restaurant_view, parent, false) as View

        return RestaurantViewHolder(restaurantView)
    }

    override fun onBindViewHolder(
            holder: RestaurantViewHolder,
            position: Int) {

        holder.restaurantView.restaurant_name.text = restaurantList[position].name
        holder.restaurantView.restaurant_max_space.text = restaurantList[position].maxSpace
    }

    // invoked by the layout manager
    override fun getItemCount() = restaurantList.size
}