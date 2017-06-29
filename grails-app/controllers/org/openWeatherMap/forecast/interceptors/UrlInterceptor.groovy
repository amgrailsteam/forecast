package org.openWeatherMap.forecast.interceptors

class UrlInterceptor {

    UrlInterceptor() {
        match controller: ~/(index)/, action: ~/(show|update)/
    }

    /**
     * Checking for valid @id value
     */
    boolean before() {
        if (!params.int('id')) {
            redirect(controller: 'index', action: 'index')
            return false
        }
        return true
    }
}