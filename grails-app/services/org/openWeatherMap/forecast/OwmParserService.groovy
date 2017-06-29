package org.openWeatherMap.forecast

import org.openWeatherMap.forecast.config.DateUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class OwmParserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwmParserService.class)

    def updateCityFromJson(City city, def json) {
        city.forecasts?.clear()
        parseCityJsonToObject(city, json.city)
        json.list.each { forecastJson ->
            city.addToForecasts(parseForecastJsonToObject(forecastJson))
        }
    }

    def parseCityJsonToObject(City city, def cityJson) {
        city.setCountryCode(cityJson.country)
        city.setName(cityJson.name)
        city.setLatitude(cityJson.coord.lat)
        city.setLongtitude(cityJson.coord.lon)
    }

    def parseForecastJsonToObject(def forecastJson) {
        Forecast forecast = new Forecast()
        forecast.setDateTime(DateUtils.toLocalDateTime(forecastJson.dt_txt))
        forecast.setTemp(forecastJson.main.temp)
        forecast.setTempMin(forecastJson.main.temp_min)
        forecast.setTempMax(forecastJson.main.temp_max)
        forecast.setPressure(forecastJson.main.pressure)
        forecast.setPressureSea(forecastJson.main.sea_level)
        forecast.setPressureGround(forecastJson.main.grnd_level)
        forecast.setHumidity(forecastJson.main.humidity)
        forecast.setCloudiness(forecastJson.clouds.all)
        forecast.setWindSpeed(forecastJson.wind.speed)
        forecast.setWindDirection(forecastJson.wind.deg)
        forecast.setRainVolume(forecastJson.rain?.'3h')
        forecast.setSnowVolume(forecastJson.snow?.'3h')
        forecast.setWeather(Weather.get(forecastJson.weather[0].id) ?: parseWeatherJsonToObject(forecastJson.weather[0]))
        return forecast
    }

    def parseWeatherJsonToObject(def weatherJson) {
        Weather weather = new Weather()
        weather.setWeatherId(weatherJson.id)
        weather.setWeatherMain(weatherJson.main)
        weather.setWeatherDescription(weatherJson.description)
        weather.setWeatherIconId(weatherJson.icon)
        if (!weather.save(flush: true)) {
            //TODO
        }
        return weather
    }
}
