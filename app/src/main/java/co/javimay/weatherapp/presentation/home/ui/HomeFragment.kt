package co.javimay.weatherapp.presentation.home.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.javimay.weatherapp.R
import co.javimay.weatherapp.di.Injector
import co.javimay.weatherapp.presentation.adapter.ReciclerViewAdapter
import co.javimay.weatherapp.presentation.city.model.City
import co.javimay.weatherapp.presentation.city.ui.CityActivity
import co.javimay.weatherapp.presentation.home.viewmodel.HomeViewModel
import co.javimay.weatherapp.presentation.home.viewmodel.HomeViewModelFactory
import co.javimay.weatherapp.utils.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    private lateinit var adapter: ReciclerViewAdapter

    @Inject
    lateinit var factory: HomeViewModelFactory
    private lateinit var homeViewModel: HomeViewModel

    private lateinit var recyclerCities: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var citiesList: List<City>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as Injector).createCitySubComponent().inject(this)
        homeViewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)
        /*val responseLiveData: LiveData<List<City>?> = homeViewModel.getCities()
        responseLiveData.observe(this, {
            citiesList = it!!
            initRecicler()
        })*/
    }

    override fun onResume() {
        super.onResume()
        val responseLiveData: LiveData<List<City>?> = homeViewModel.getCities()
        responseLiveData.observe(this, {
            citiesList = it!!
            initRecicler()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerCities = view.findViewById(R.id.rv_cities)
        return view
    }

    private fun initRecicler() {
        viewManager = LinearLayoutManager(context)
        adapter = ReciclerViewAdapter(citiesList.toMutableList(), context) {position ->
            val responseLiveData: LiveData<Boolean> = homeViewModel.deleteCity(citiesList[position])
            responseLiveData.observe(this, {
                adapter.notifyDataSetChanged()
            })
        }
        adapter.onItemClick = {position ->
            GoToCityActivity(citiesList[position])

        }
        recyclerCities.adapter = adapter
        recyclerCities.layoutManager = viewManager
    }

    private fun GoToCityActivity(city: City) {
        val intent = Intent(context, CityActivity::class.java).apply {
            putExtra(CITY_NAME, city.name)
            putExtra(CITY_LATITUDE, city.latitude)
            putExtra(CITY_LONGITUDE, city.longitude)
            putExtra(CITY_COUNTRY, city.country)
            putExtra(CITY_STATE, city.state)
        }
        startActivity(intent)
    }
}