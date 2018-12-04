package hu.uniobuda.nik.fitorfull

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {

    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap

    fun createLocalDatabase() {
        val FILENAME = "restaurants.dat"
        val saveThis = "Helló Storage!"
        val fos = openFileOutput(FILENAME, Context.MODE_PRIVATE)
        fos.write(saveThis.toByteArray())
        fos.close()
    }

    fun loadRestaurantData(){
        val fis = openFileInput("restaurants.dat")
        val buffer = ByteArray(1024)
        var len: Int
        len = fis.read(buffer)
        while (len > 0) {
            Log.d("TAG", String(buffer, 0, len))
            len = fis.read(buffer)
        }
        fis.close()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createLocalDatabase()

        loadRestaurantData()

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it
            googleMap.isMyLocationEnabled = true

            val location1 = LatLng(47.53505161,19.03607726)
            googleMap.addMarker(MarkerOptions().position(location1).title("My Location"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,15f))

        })



    }
}
