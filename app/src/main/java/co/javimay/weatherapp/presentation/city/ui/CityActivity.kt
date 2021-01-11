package co.javimay.weatherapp.presentation.city.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.javimay.weatherapp.R
import co.javimay.weatherapp.data.api.model.Weather
import co.javimay.weatherapp.databinding.ActivityCityBinding
import co.javimay.weatherapp.di.Injector
import co.javimay.weatherapp.presentation.city.model.City
import co.javimay.weatherapp.presentation.city.viewmodel.CityViewModel
import co.javimay.weatherapp.presentation.city.viewmodel.CityViewModelFactory
import co.javimay.weatherapp.utils.*
import javax.inject.Inject

class CityActivity : AppCompatActivity() {

    companion object {
        val TAG = CityActivity::class.java.simpleName
    }

    @Inject
    lateinit var factory: CityViewModelFactory
    private lateinit var cityViewModel: CityViewModel
    private lateinit var binding: ActivityCityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_city)
        (application as Injector).createWeatherSubComponent().inject(this)
        cityViewModel = ViewModelProvider(this, factory).get(CityViewModel::class.java)
        //setContentView(R.layout.activity_city)
        val cityName = intent.getStringExtra(CITY_NAME)
        val cityLatitude = intent.getDoubleExtra(CITY_LATITUDE, 0.0)
        val cityLongitude = intent.getDoubleExtra(CITY_LONGITUDE, 0.0)
        val cityCountry = intent.getStringExtra(CITY_COUNTRY)
        val cityState = intent.getIntExtra(CITY_STATE, 0)
        val city = City(
            name = cityName!!,
            latitude = cityLatitude,
            longitude = cityLongitude,
            country = cityCountry!!,
            state = cityState,
            id = null)
        binding.tvCityName.text = cityName
        val responsseLiveData: LiveData<Weather?> = cityViewModel.getWeather(city)
        responsseLiveData.observe(this, Observer {
            Log.i(TAG, it.toString())
            showWeather(it)
        })
    }

    private fun showWeather(weather: Weather?) {
        binding.tvForecast.text = String.format(getString(R.string.txt_city_forecast, weather?.weatherInfo?.get(0)?.main))
        binding.tvTemperature.text = String.format(getString(R.string.txt_city_temperature, weather?.main?.temp.toString()))
        binding.tvHumidity.text = String.format(getString(R.string.txt_city_humidity, weather?.main?.humidity.toString()))
        binding.tvRain.text = String.format(getString(R.string.txt_city_rain_chances, weather?.clouds?.all.toString()))
        binding.tvWind.text = String.format(getString(R.string.txt_city_wind, weather?.wind?.speed.toString()))
    }
}