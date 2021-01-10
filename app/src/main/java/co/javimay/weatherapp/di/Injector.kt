package co.javimay.weatherapp.di

import co.javimay.weatherapp.di.city.CitySubComponent
import co.javimay.weatherapp.di.map.MapSubComponent
import co.javimay.weatherapp.di.weather.WeatherSubComponent

interface Injector {

    fun createCitySubComponent(): CitySubComponent
    fun createWeatherSubComponent(): WeatherSubComponent
    fun createMapSubComponent(): MapSubComponent
}