package org.openWeatherMap.forecast

import org.joda.time.LocalDateTime

class Forecast {

    LocalDateTime dateTime
    BigDecimal temp
    BigDecimal tempMin
    BigDecimal tempMax
    BigDecimal pressure
    BigDecimal pressureSea
    BigDecimal pressureGround
    int humidity
    int cloudiness
    BigDecimal windSpeed
    BigDecimal windDirection
    BigDecimal rainVolume
    BigDecimal snowVolume
    Weather weather

    static constraints = {
        humidity range: 0..100
        cloudiness range: 0..100
    }

    static belongsTo = [city: City]

    static mapping = {
        version false
    }
}
