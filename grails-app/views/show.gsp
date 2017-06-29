<%@ page import="org.joda.time.LocalDate" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <asset:stylesheet src="application.css"/>
</head>

<body>
<content tag="content">
    <div class="container">

        <div class="main">
            <div class="operations">
                <g:link action="index" class="btn btn-default export_vin_to_xml">
                    <i class="glyphicon glyphicon-list-alt"></i>&nbsp;${message(code: 'default.home.label')}
                </g:link>
                <g:link action="update" class="btn btn-default"
                        params="[id: city.id]">
                    <i class="glyphicon glyphicon-refresh"></i>&nbsp;${message(code: 'default.button.update.label')}
                </g:link>
            </div>

            <div class="current">
                <g:render template="/templates/forecastCurrent" model="[city: city]"/>
            </div>
        </div>

        <div class="forecasts">
            <h2><g:message code="forecast.header.label"/></h2>

            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#today"><g:message code="tabs.today.label"/></a></li>
                <li><a data-toggle="tab" href="#tomorrow"><g:message code="tabs.tomorrow.label"/></a></li>
                <li><a data-toggle="tab" href="#week"><g:message code="tabs.week.label"/></a></li>
            </ul>

            <div class="tab-content">
                <div id="today" class="tab-pane fade in active">
                    <g:render template="/templates/forecastList" model="[forecastList: city.forecasts.findAll {
                        it.dateTime.toLocalDate().equals(org.joda.time.LocalDate.now())
                    }]"/>
                </div>

                <div id="tomorrow" class="tab-pane fade">
                    <g:render template="/templates/forecastList" model="[forecastList: city.forecasts.findAll {
                        it.dateTime.toLocalDate().equals(org.joda.time.LocalDate.now().plusDays(1))
                    }]"/>
                </div>

                <div id="week" class="tab-pane fade">
                    <g:render template="/templates/forecastList" model="[forecastList: city.forecasts]"/>
                </div>
            </div>
        </div>
    </div>
</content>
</body>
</html>
