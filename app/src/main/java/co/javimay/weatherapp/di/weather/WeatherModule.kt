package co.javimay.weatherapp.di.weather

import co.javimay.weatherapp.domain.usecase.weather.GetWeatherUseCase
import co.javimay.weatherapp.presentation.city.viewmodel.CityViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class WeatherModule {

    @WeatherScope
    @Provides
    fun provideWeatherViewModelFactory(
        getWeatherUseCase: GetWeatherUseCase,
    ): CityViewModelFactory
            = CityViewModelFactory(getWeatherUseCase)
}

