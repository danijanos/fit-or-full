package hu.uniobuda.nik.fitorfull

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {

    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap

    fun createLocalDatabase() {
        val FILENAME = "restaurants.dat"
        val saveThis = "markers"
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

    fun CreateMap()
    {
        createLocalDatabase()

        loadRestaurantData()

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it

            googleMap.isMyLocationEnabled = true

            CreateMarkers();
        })
    }

    fun CreateMarkers()
    {
        val location1 = LatLng(47.53505161, 19.03607726)
        googleMap.addMarker(MarkerOptions().position(location1).title("Gombás étterem [SZABAD HELYEK: 12]").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))

        val location2 = LatLng(47.5343997, 19.03706431)
        googleMap.addMarker(MarkerOptions().position(location2).title("'Fater főzte' vendéglő [SZABAD HELYEK: 0]").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)))

        val location3 = LatLng(47.53597152, 19.03395295)
        googleMap.addMarker(MarkerOptions().position(location3).title("Rekettyés étterem [SZABAD HELYEK: 4]").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))


        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 15f))
    }

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (Build.VERSION.SDK_INT<23) {
            CreateMap()
        }
        else
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION),123)

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==123)
        {
            if ((grantResults[0]==PackageManager.PERMISSION_GRANTED) && (grantResults[0]==PackageManager.PERMISSION_GRANTED))
            {
               CreateMap()
            }
        }
    }
}
