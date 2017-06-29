package org.openWeatherMap.forecast.interceptors

import org.openWeatherMap.forecast.City

class DocResolveInterceptor {

    int order = LOWEST_PRECEDENCE

    DocResolveInterceptor() {
        match controller: ~/(index)/, action: ~/(show|update)/
    }

    /**
     * Checking for City existence in db for the given @id
     */
    boolean before() {
        if (!City.get(params.int('id'))) {
            redirect(action: 'index')
            return false
        }
        return true
    }
}