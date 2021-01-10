package co.javimay.weatherapp.di.map

import co.javimay.weatherapp.di.city.CityModule
import co.javimay.weatherapp.di.city.CityScope
import co.javimay.weatherapp.presentation.map.ui.MapFragment
import dagger.Subcomponent

@MapScope
@Subcomponent(modules = [MapModule::class])
interface MapSubComponent {
    fun inject(mapFragment: MapFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MapSubComponent
    }
}