package co.javimay.weatherapp.di.core

import co.javimay.weatherapp.data.db.CityDao
import co.javimay.weatherapp.data.repository.city.datasource.CityLocalDataSource
import co.javimay.weatherapp.data.repository.city.datasourceimpl.CityLocalDataSurceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideCityLocalDataSource(cityDao: CityDao): CityLocalDataSource
            = CityLocalDataSurceImpl(cityDao)
}