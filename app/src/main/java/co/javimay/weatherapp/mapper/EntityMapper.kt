package co.javimay.weatherapp.mapper

interface EntityMapper<R, D> {
    fun mapFromRemote(type: R): D?
    fun mapToRemote(type: D): R?
}