package co.javimay.weatherapp.di.weather

import co.javimay.weatherapp.presentation.city.ui.CityActivity
import dagger.Subcomponent

@WeatherScope
@Subcomponent(modules = [WeatherModule::class])
interface WeatherSubComponent {
    fun inject(cityActivity: CityActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): WeatherSubComponent
    }
}