package co.javimay.weatherapp.di.core

import android.content.Context
import co.javimay.weatherapp.di.city.CitySubComponent
import co.javimay.weatherapp.di.map.MapSubComponent
import co.javimay.weatherapp.di.weather.WeatherSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [CitySubComponent::class, WeatherSubComponent::class, MapSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context = context.applicationContext

}