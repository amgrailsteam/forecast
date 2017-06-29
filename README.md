# forecast
OWM rest client configuration readme

Please note that the following configuration with default values is already defined in app's application.groovy.
You are free to change for a desired configuration.

org {
    openWeatherMap {
        forecast {
            /**
             *  OWM 5/3 forecasts rest url
             */
            owmRequestUrl = 'http://api.openweathermap.org/data/2.5/forecast'

            /**
             *  OWM 5/3 forecasts rest key
             */
            owmRequestKey = '08ff52cc43382ec390a9a409b87668a7'

            /**
             *  Predefined list of desired cities ids
             */
            citiesIds = [588409, 588335, 3078610]

            /**
             *  Cron for automatic forecasts updates scheduling
             */
            schedulerCron = "1/12 * * * * *"
        }
    }
}
