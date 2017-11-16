package clients

import model.Customer

class CustomerClient {
    ApiClient apiClient = new ApiClient("https://api.bancogalicia.com.ar/apiCustomer")

    def post(Customer customer) {
        def response = apiClient.post("/Customer", customer.to_json())
        response
    }

    def getAll() {
        def response = apiClient.get("/Customer")
        response
    }

    def get(id) {
        def response = apiClient.get("/Customer/${id}")
        response
    }

    def getClientName(clientId){
        def client = get(clientId)
        return "${client.First_Name} ${client.Last_Name}"
    }
}