<%@ page import="org.openWeatherMap.forecast.utils.DateUtils; org.joda.time.LocalDate;org.openWeatherMap.forecast.Forecast;" %>
<tr class="forecastItem">
    <td>
        <p>${org.openWeatherMap.forecast.utils.DateUtils.toTime(forecast.dateTime)}</p>

        <g:if test="${forecast.dateTime.toLocalDate().equals(LocalDate.now())}">
            <g:message code="tabs.today.label"/>
        </g:if>
        <g:else>
            <p>${org.openWeatherMap.forecast.utils.DateUtils.toDate(forecast.dateTime)}</p>
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
            <g:message code="forecast.wind.label"/>
            <g:message code="valueSeparator"/>
            ${forecast.windSpeed}
            <g:message code="forecast.wind.uom.label"/>
            <g:message code="separator"/>
            &nbsp;

            <g:message code="forecast.clouds.label"/>
            <g:message code="valueSeparator"/>
            ${forecast.cloudiness}
            <g:message code="forecast.clouds.uom.label"/>
            <g:message code="separator"/>
            &nbsp;

            <g:message code="forecast.pressure.label"/>
            <g:message code="valueSeparator"/>
            ${forecast.pressure}
            <g:message code="forecast.pressure.uom.label"/>
        </p>
    </td>
</tr>