package clients

import grails.plugins.rest.client.RestBuilder
import grails.converters.JSON


class ApiClient {
    def rest = new RestBuilder(connectTimeout: 10000, readTimeout: 20000)
    String baseUrl


    ApiClient(String url) {
        baseUrl = url
    }

    def post(String url, Map form) {
        url = addApiKeyAndQueryParams(url)
        def response = rest.post(url) {
            body(form as JSON)
        }
        response.json
    }

    def put(String url, Map form){
        url =addApiKeyAndQueryParams(url)
        def response = rest.put(url) {
            body(form as JSON)
        }
        response.json
    }

    def get(String url, Map params = [:]) {
        url = addApiKeyAndQueryParams(url, params)
        def response = rest.get(url) {
            accept("application/json")
        }
        response.json
    }

    def addApiKeyAndQueryParams(String url, Map params = [:]) {
        def apiKey = "secretApikeY"
        def urlParams = "?apikey=${apiKey}"

        params.each { key, value ->
            urlParams += key + "=" + value + "&"
        }
        url = baseUrl + url + urlParams
        url
    }
}