package org.openWeatherMap.forecast

class Weather {
    Long weatherId
    String weatherMain
    String weatherDescription
    String weatherIconId

    static constraints = {
        weatherMain maxSize: 255
        weatherDescription maxSize: 255
        weatherIconId maxSize: 4
    }

    static mapping = {
        version false
        id name: 'weatherId', generator: 'assigned'
    }
}
