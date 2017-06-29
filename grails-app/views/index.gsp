<%@ page import="org.openWeatherMap.forecast.utils.DateUtils" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
</head>

<body>
<content tag="content">
    <div class="container">
        <h2>Cities List</h2>
        <table class="table table-condensed">
            <thead>
            <tr>
                <th>City ID</th>
                <th>City Name</th>
                <th>Country</th>
                <th>Last Update</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="city" in="${cities}" status="i">
                <tr onclick='window.location = "/index/show/${city.id}";'>
                    <td>${city.id}</td>
                    <td>${city.name}</td>
                    <td>${city.countryCode}</td>
                    <td>${DateUtils.toExtendedTime(city.lastUpdate)}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</content>
</body>
</html>
