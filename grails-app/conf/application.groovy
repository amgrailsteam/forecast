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
            owmRequestUrl = 'http://api.openweathermap.org/data/2.5/forecast'
            owmRequestKey = '08ff52cc43382ec390a9a409b87668a7'
            citiesIds = [707860, 519188, 1283378]
            schedulerCron = "1/12 * * * * *"
        }
    }
}


