package org.openWeatherMap.forecast

import org.joda.time.LocalDateTime

class City {

    String name
    BigDecimal longitude
    BigDecimal latitude
    String countryCode
    LocalDateTime lastUpdate
    List<Forecast> forecasts

    static constraints = {
        countryCode minSize: 2, maxSize: 2
        name maxSize: 255
    }

    static mapping = {
        version false
        id generator: 'assigned'
        forecasts cascade: "all-delete-orphan"
    }

    static hasMany = [forecasts: Forecast]

    Forecast getCurrentForecast() {
        return forecasts?.get(0)
    }

    def beforeUpdate() {
        setLastUpdate(LocalDateTime.now())
    }
}