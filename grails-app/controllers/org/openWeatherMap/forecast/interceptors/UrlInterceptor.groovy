package org.openWeatherMap.forecast.interceptors

class UrlInterceptor {

    UrlInterceptor() {
        match controller: ~/(index)/, action: ~/(show|update)/
    }

    boolean before() {
        if (!params.int('id')) {
            redirect(controller: 'index', action: 'index')
            return false
        }
        return true
    }
}
