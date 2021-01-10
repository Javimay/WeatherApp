package co.javimay.weatherapp.di.core

import co.javimay.weatherapp.di.city.CitySubComponent
import co.javimay.weatherapp.di.map.MapSubComponent
import co.javimay.weatherapp.di.weather.WeatherSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DataBaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class]
)
interface AppComponent {
    fun citySubComponent(): CitySubComponent.Factory
    fun weatherSubComponent(): WeatherSubComponent.Factory
    fun mapSubComponent(): MapSubComponent.Factory
}