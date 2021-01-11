package co.javimay.weatherapp.presentation.map.ui

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import co.javimay.weatherapp.R
import co.javimay.weatherapp.di.Injector
import co.javimay.weatherapp.presentation.city.model.City
import co.javimay.weatherapp.presentation.map.viewmodel.MapViewModel
import co.javimay.weatherapp.presentation.map.viewmodel.MapViewModelFactory
import co.javimay.weatherapp.utils.INITIAL_LOCATION
import co.javimay.weatherapp.utils.STATE_FAVORITE
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.MarkerOptions
import androidx.lifecycle.Observer
import java.util.*
import javax.inject.Inject


class MapFragment : Fragment(), OnMapReadyCallback {

    companion object{
        val TAG = MapFragment::class.java.simpleName
    }

    @Inject
    lateinit var factory: MapViewModelFactory
    private lateinit var mapViewModel: MapViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        (activity?.application as Injector).createMapSubComponent().inject(this)
        mapViewModel = ViewModelProvider(this, factory).get(MapViewModel::class.java)
        return view
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(INITIAL_LOCATION, 10F))
        googleMap?.setOnMapLongClickListener {
            val markerOptions = MarkerOptions()
            markerOptions.position(it)
            val city = getCity(it.latitude, it.longitude)
            markerOptions.title(city?.name)
            markerOptions.snippet(String.format(getString(R.string.map_marker_add_city), city?.name))
            googleMap.clear()
            googleMap.setOnInfoWindowClickListener { marker ->
                if (city!=null){
                val responsseLiveData: LiveData<Boolean> = mapViewModel.saveCities(city)
                responsseLiveData.observe(this, {
                    Toast.makeText(context, String.format(getString(R.string.map_marker_add_city_confirmation), city?.name),
                        Toast.LENGTH_LONG)
                        .show()
                    Log.i(TAG, it.toString())
                    marker.hideInfoWindow()
                })
                }else  marker.snippet = getString(R.string.map_marker_error_location)
            }
            googleMap.addMarker(markerOptions).showInfoWindow()
        }
    }

    fun getCity(latitude: Double, longitude: Double): City?{
        val gcd = Geocoder(context, Locale.getDefault())
        val addresses: List<Address> = gcd.getFromLocation(latitude, longitude, 1)
        if (addresses.isNotEmpty()) {
            val city = City(
                name = if(!addresses[addresses.lastIndex].locality.isNullOrEmpty())
                    addresses[addresses.lastIndex].locality
                            else "UNKNOW",
                country = if(!addresses[addresses.lastIndex].countryName.isNullOrEmpty())
                    addresses[addresses.lastIndex].countryName
                else "UNKNOW",
                latitude = addresses[addresses.lastIndex].latitude,
                longitude = addresses[addresses.lastIndex].longitude,
                state = STATE_FAVORITE, id = null
            )
            return city
        } else {
            return null
        }
    }
}