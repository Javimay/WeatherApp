package co.javimay.weatherapp.di.core

import co.javimay.weatherapp.domain.repository.CityRepository
import co.javimay.weatherapp.domain.repository.WeatherRepository
import co.javimay.weatherapp.domain.usecase.city.DeleteCityUseCase
import co.javimay.weatherapp.domain.usecase.city.GetCityUseCase
import co.javimay.weatherapp.domain.usecase.city.SaveCityUseCase
import co.javimay.weatherapp.domain.usecase.weather.GetWeatherUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetCityUseCase(cityRepository: CityRepository):GetCityUseCase
            = GetCityUseCase(cityRepository)

    @Singleton
    @Provides
    fun provideSaveCityUseCase(cityRepository: CityRepository):SaveCityUseCase
            = SaveCityUseCase(cityRepository)

    @Singleton
    @Provides
    fun provideDeleteCityUseCase(cityRepository: CityRepository):DeleteCityUseCase
            = DeleteCityUseCase(cityRepository)

    @Singleton
    @Provides
    fun provideGetWeatherUseCase(weatherRepository: WeatherRepository): GetWeatherUseCase
            = GetWeatherUseCase(weatherRepository)
}