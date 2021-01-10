package co.javimay.weatherapp.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import co.javimay.weatherapp.utils.CITY

@Entity(tableName = CITY)
data class City(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
    val state: Int,
)


