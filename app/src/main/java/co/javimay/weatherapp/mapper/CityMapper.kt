package co.javimay.weatherapp.mapper

import co.javimay.weatherapp.data.db.model.City

class CityMapper:EntityMapper<City, co.javimay.weatherapp.presentation.city.model.City> {
    override fun mapFromRemote(type: City): co.javimay.weatherapp.presentation.city.model.City? {
        TODO("Not yet implemented")
    }

    override fun mapToRemote(type: co.javimay.weatherapp.presentation.city.model.City): City? {
        return with(type){
            City(name = this.name,
                country = this.country,
                latitude = this.latitude,
                longitude = this.longitude,
                state = this.state, id = null)
        }
    }
}