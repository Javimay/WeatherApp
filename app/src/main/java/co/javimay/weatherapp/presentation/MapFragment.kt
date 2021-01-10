package co.javimay.weatherapp.presentation

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.javimay.weatherapp.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*


class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    companion object {
        var mapFragment : SupportMapFragment?=null
        val TAG: String = MapFragment::class.java.simpleName
        fun newInstance() = MapFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return view
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap?.setOnMapLongClickListener {
            val markerOptions = MarkerOptions()
            markerOptions.position(it)
            val city = getCityName(it.latitude, it.longitude)
            markerOptions.title(city)
            markerOptions.snippet("Quiere agregar ${city} a favoritos?")
            googleMap.clear()
            googleMap.setOnInfoWindowClickListener {
                Toast.makeText(context,"Se ha agregado $city a los favoritos",Toast.LENGTH_LONG)
                    .show()
            }
            googleMap.addMarker(markerOptions).showInfoWindow()
        }
    }

    fun getCityName(latitude: Double, longitude: Double):String{
        val gcd = Geocoder(context, Locale.getDefault())
        val addresses: List<Address> = gcd.getFromLocation(latitude, longitude, 1)
        if (addresses.size > 0) {
            val city = if(!addresses[addresses.lastIndex].locality.isNullOrEmpty())
                addresses[addresses.lastIndex].locality
            else addresses[addresses.lastIndex].postalCode
            return (city)
        } else {
            return ("${latitude} : ${longitude}")
        }
    }
}