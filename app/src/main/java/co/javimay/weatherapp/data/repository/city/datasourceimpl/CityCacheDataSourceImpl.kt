package co.javimay.weatherapp.data.repository.city.datasourceimpl

import co.javimay.weatherapp.data.model.City
import co.javimay.weatherapp.data.repository.city.datasource.CityCacheDataSource

class CityCacheDataSourceImpl:CityCacheDataSource {

    private var cityList = ArrayList<City>()
    override suspend fun getCityFromCache(): List<City> = cityList

    override suspend fun saveCityToCache(city: City) {
        cityList.clear()
        cityList.add(city)
    }
}