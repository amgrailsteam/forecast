package org.openWeatherMap.forecast

class IndexController {
    def owmClientService

    def index() {
        render(view: "/index", model: [cities: City.list()])
    }

    def show() {
        render(view: "/show", model: [city: City.get(params.int('id'))])
    }

    def update() {
        City city = City.get(params.int('id'))
        owmClientService.updateForecast(city)
        redirect(action: 'show', params: [id: city.id])
    }
}