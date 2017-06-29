package org.openWeatherMap.forecast

import org.grails.web.json.JSONElement
import org.openWeatherMap.forecast.utils.DateUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class OwmParserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OwmParserService.class)

    /**
     * Method for updating city's forecast data from OWM response
     * @param city
     * @param owmResponse
     */
    void updateCityFromJson(City city, JSONElement owmResponse) {
        city.forecasts?.clear()
        parseCityJsonToObject(city, owmResponse.city)
        owmResponse.list.each { forecastJson ->
            city.addToForecasts(parseForecastJsonToObject(forecastJson))
        }
    }

    /**
     * Method for parsing city data
     * @param city
     * @param cityJson
     */
    void parseCityJsonToObject(City city, JSONElement cityJson) {
        city.setCountryCode(cityJson.country)
        city.setName(cityJson.name)
        city.setLatitude(cityJson.coord.lat)
        city.setLongitude(cityJson.coord.lon)
    }

    /**
     * Method for parsing hpurly forecasts data
     * @param forecastJson
     * @return parsed hourly forecast item
     */
    Forecast parseForecastJsonToObject(JSONElement forecastJson) {
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

    /**
     * Method for parsing hourly forecast's weather conditions data
     * @param weatherJson
     * @return hourly forecast's weather conditions data
     */
    Weather parseWeatherJsonToObject(JSONElement weatherJson) {
        Weather weather = new Weather()
        weather.setWeatherId(weatherJson.id)
        weather.setWeatherMain(weatherJson.main)
        weather.setWeatherDescription(weatherJson.description)
        weather.setWeatherIconId(weatherJson.icon)
        if (!weather.save(flush: true)) {
            LOGGER.error("Unable to flash weather instance with parameters: ${weather.properties}")
        }
        return weather
    }
}
