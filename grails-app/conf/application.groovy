grails.gorm.default.constraints = {
    '*'(nullable: true)
}

grails.gorm.default.mapping = {
    "user-type" type: org.jadira.usertype.dateandtime.joda.PersistentDateTime, class: org.joda.time.DateTime
    "user-type" type: org.jadira.usertype.dateandtime.joda.PersistentLocalDate, class: org.joda.time.LocalDate
    "user-type" type: org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime, class: org.joda.time.LocalDateTime
}


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