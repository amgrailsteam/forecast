<%@ page import="org.joda.time.LocalDate; org.openWeatherMap.forecast.config.DateUtils;org.openWeatherMap.forecast.Forecast;" %>
<tr class="forecastItem">
    <td>
        <p>${DateUtils.toTime(forecast.dateTime)}</p>

        <g:if test="${forecast.dateTime.toLocalDate().equals(LocalDate.now())}">
            <g:message code="tabs.today.label"/>
        </g:if>
        <g:else>
            <p>${DateUtils.toDate(forecast.dateTime)}</p>
        </g:else>
    </td>
    <td>
        <img src="http://openweathermap.org/img/w/${forecast.weather?.weatherIconId}.png">
    </td>
    <td>
        <p>
            <span>${forecast.temp}°C</span>&nbsp;&nbsp;<i>${forecast.weather.weatherDescription}</i>
        </p>

        <p>
        </p>
    </td>
</tr>