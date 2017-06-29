package org.openWeatherMap.forecast.utils

import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

class DateUtils {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm")
    private static final DateTimeFormatter TIME_FORMATTER_FULL = DateTimeFormat.forPattern("HH:mm:ss")
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("dd MMM yyyy")

    static LocalDateTime toLocalDateTime(Object obj) {
        String str = getString(obj)

        if (str) {
            return DATE_TIME_FORMATTER.parseLocalDateTime(str)
        }
        return null
    }

    static String toTime(LocalDateTime localDateTime) {
        getFormattedString(localDateTime, TIME_FORMATTER)
    }

    static String toExtendedTime(LocalDateTime localDateTime) {
        getFormattedString(localDateTime, TIME_FORMATTER_FULL)
    }

    static String toDate(LocalDateTime localDateTime) {
        getFormattedString(localDateTime, DATE_FORMATTER)
    }

    static String getFormattedString(LocalDateTime localDateTime, DateTimeFormatter pattern) {
        if (localDateTime) {
            return pattern.print(localDateTime)
        }

        return null
    }

    static String getString(Object obj) {
        if (obj) {
            String str = obj.toString()

            if (!str.isEmpty()) {
                return str
            }
        }
        return null
    }
}