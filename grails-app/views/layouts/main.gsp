<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="OWM Client"/>
    </title>
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
</head>

<body>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Application Status <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>
                        <li><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>
                        <li><a href="#">App version:
                            <g:meta name="info.app.version"/></a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Grails version:
                            <g:meta name="info.app.grailsVersion"/></a>
                        </li>
                        <li><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>
                        <li><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Artefacts <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>
                        <li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>
                        <li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>
                        <li><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Installed Plugins <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
                            <li><a href="#">${plugin.name} - ${plugin.version}</a></li>
                        </g:each>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>

<g:pageProperty name="page.content"/>

<div class="footer" role="contentinfo"></div>

<asset:javascript src="application.js"/>

</body>
</html>
