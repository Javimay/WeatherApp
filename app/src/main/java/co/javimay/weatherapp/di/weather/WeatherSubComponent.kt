package co.javimay.weatherapp.di.weather

import co.javimay.weatherapp.presentation.home.ui.HomeFragment
import dagger.Subcomponent

@WeatherScope
@Subcomponent(modules = [WeatherModule::class])
interface WeatherSubComponent {
    fun inject(homeFragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): WeatherSubComponent
    }
}