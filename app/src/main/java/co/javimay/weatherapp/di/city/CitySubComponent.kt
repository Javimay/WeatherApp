package co.javimay.weatherapp.di.city

import co.javimay.weatherapp.presentation.home.ui.HomeFragment
import dagger.Subcomponent

@CityScope
@Subcomponent(modules = [CityModule::class])
interface CitySubComponent {
    fun inject(homeFragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): CitySubComponent
    }
}