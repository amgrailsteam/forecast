<p class="currentHeader">Current Weather In ${city.name}</p>
<table class="table table-condensed">
    <tr class="currentForecast">
        <td>
            <img src="http://openweathermap.org/img/w/${city.currentForecast.weather?.weatherIconId}.png"
                 class="weatherIcon">
        </td>
        <td>
            <p>${city.currentForecast.temp}°C</p>
            <p>${city.currentForecast.weather.weatherDescription.capitalize()}</p>
        </td>
    </tr>
    <tr>
        <td>
            <g:message code="forecast.wind.label"/>
        </td>
        <td>
            ${city.currentForecast.windSpeed}&nbsp;<g:message code="forecast.wind.uom.label"/>
        </td>
    </tr>

    <tr>
        <td>
            <g:message code="forecast.clouds.label"/>
        </td>
        <td>
            ${city.currentForecast.cloudiness}&nbsp;<g:message code="forecast.clouds.uom.label"/>
        </td>
    </tr>

    <tr>
        <td>
            <g:message code="forecast.pressure.label"/>
        </td>
        <td>
            ${city.currentForecast.pressure}&nbsp;<g:message code="forecast.pressure.uom.label"/>
        </td>
    </tr>

    <tr>
        <td>
            <g:message code="forecast.humidity.label"/>
        </td>
        <td>
            ${city.currentForecast.humidity}&nbsp;<g:message code="forecast.humidity.uom.label"/>
        </td>
    </tr>

    <tr>
        <td>
            <g:message code="forecast.geoLocation.label"/>
        </td>
        <td>
            [${city.longitude}, ${city.latitude}]
        </td>
    </tr>
</table>