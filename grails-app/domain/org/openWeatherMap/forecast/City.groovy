package org.openWeatherMap.forecast

import org.joda.time.LocalDateTime

class City {
    String name
    BigDecimal longtitude
    BigDecimal latitude
    String countryCode
    LocalDateTime lastUpdate
    List<Forecast> forecasts

    static constraints = {
        countryCode size: 2..2
        name maxSize: 255
    }

    static mapping = {
        version false
        id generator: 'assigned'
    }

    static hasMany = [forecasts: Forecast]

    Forecast getCurrentForecast() {
        return forecasts?.get(0)
    }

    def beforeUpdate() {
        setLastUpdate(LocalDateTime.now())
    }
}
