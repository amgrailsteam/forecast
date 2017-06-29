<%@ page import="org.openWeatherMap.forecast.utils.DateUtils;java.time.DayOfWeek" %>
<tr>
    <td colspan="3" class="forecastListSeparator">
        <g:message
                code="weekday.${forecast.dateTime.dayOfWeek}.label"/>&nbsp;${org.openWeatherMap.forecast.utils.DateUtils.toDate(forecast.dateTime)}
    </td>
</tr>