package hu.uniobuda.nik.fitorfull

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import hu.uniobuda.nik.fitorfull.adapters.RestaurantListAdapter
import hu.uniobuda.nik.fitorfull.models.Restaurant

class RestaurantListActivity : AppCompatActivity() {

    private lateinit var restaurants: Array<Restaurant>

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)

        viewManager = LinearLayoutManager(this)
        viewAdapter = RestaurantListAdapter(restaurants)

        recyclerView = findViewById<RecyclerView>(R.id.restaurant_list_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
