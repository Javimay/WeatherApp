package co.javimay.weatherapp.presentation.home.ui

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
import co.javimay.weatherapp.presentation.home.viewmodel.HomeViewModel
import co.javimay.weatherapp.presentation.home.viewmodel.HomeViewModelFactory
import javax.inject.Inject

class HomeFragment : Fragment() {

    companion object {
        val TAG = HomeFragment::class.java.simpleName
    }

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
        val responsseLiveData: LiveData<List<City>?> = homeViewModel.getCities()
        responsseLiveData.observe(this, {
            citiesList = it!!
            initRecicler()
        })
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
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
            val responsseLiveData: LiveData<Boolean> = homeViewModel.deleteCity(citiesList[position])
            responsseLiveData.observe(this, {
                adapter.notifyDataSetChanged()
            })
        }
        recyclerCities.adapter = adapter
        recyclerCities.layoutManager = viewManager
    }
}