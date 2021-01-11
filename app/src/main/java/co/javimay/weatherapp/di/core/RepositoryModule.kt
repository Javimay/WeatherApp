package co.javimay.weatherapp.di.core

import co.javimay.weatherapp.data.repository.city.CityRepositoryImpl
import co.javimay.weatherapp.data.repository.city.datasource.CityLocalDataSource
import co.javimay.weatherapp.data.repository.weather.WeatherRepositoryImpl
import co.javimay.weatherapp.data.repository.weather.datasource.WeatherRemoteDataSource
import co.javimay.weatherapp.domain.repository.CityRepository
import co.javimay.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideCityRepository(
        cityLocalDataSource: CityLocalDataSource
    ): CityRepository = CityRepositoryImpl(cityLocalDataSource)

    @Singleton
    @Provides
    fun provideWeatherRepository(
        weatherRemoteDataSource: WeatherRemoteDataSource,
    ): WeatherRepository = WeatherRepositoryImpl(weatherRemoteDataSource)
}