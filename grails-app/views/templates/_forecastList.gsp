<table class="table table-condensed">
    <tbody>
    <g:each var="forecast" in="${forecastList}" status="i">
        <g:if test="${forecast.dateTime.hourOfDay == 0}">
            <g:render template="/templates/forecastListSeparator" model="[forecast: forecast]"/>
        </g:if>
        <g:render template="/templates/forecastListItem" model="[forecast: forecast]"/>
    </g:each>
    </tbody>
</table>