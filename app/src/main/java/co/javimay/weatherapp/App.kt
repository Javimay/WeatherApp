package co.javimay.weatherapp

import android.app.Application
import co.javimay.weatherapp.di.Injector
import co.javimay.weatherapp.di.city.CitySubComponent
import co.javimay.weatherapp.di.core.*
import co.javimay.weatherapp.di.map.MapSubComponent
import co.javimay.weatherapp.di.weather.WeatherSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.API_BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createCitySubComponent(): CitySubComponent =
        appComponent.citySubComponent().create()

    override fun createWeatherSubComponent(): WeatherSubComponent =
        appComponent.weatherSubComponent().create()

    override fun createMapSubComponent(): MapSubComponent =
        appComponent.mapSubComponent().create()
}