<%@ page import="org.openWeatherMap.forecast.config.DateUtils; java.time.DayOfWeek" %>
<tr>
    <td colspan="3" class="forecastListSeparator">
        <g:message
                code="weekday.${forecast.dateTime.dayOfWeek}.label"/>&nbsp;${DateUtils.toDate(forecast.dateTime)}
    </td>
</tr>