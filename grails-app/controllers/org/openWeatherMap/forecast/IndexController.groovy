package org.openWeatherMap.forecast

class IndexController {
    def owmClientService

    /***
     * Renders cities list
     */
    def index() {
        render(view: "/index", model: [cities: City.list()])
    }

    /***
     * Renders detailed forecast data for the selected City
     */
    def show() {
        render(view: "/show", model: [city: City.get(params.int('id'))])
    }

    /***
     * Updates the forecast data for the city with @id and shows it
     */
    def update() {
        City city = City.get(params.int('id'))
        owmClientService.updateForecast(city)
        redirect(action: 'show', params: [id: city.id])
    }
}