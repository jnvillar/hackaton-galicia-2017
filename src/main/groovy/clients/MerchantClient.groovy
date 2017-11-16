package clients

import model.Merchant

class MerchantClient {
    ApiClient apiClient = new ApiClient("https://api.bancogalicia.com.ar/apiMerchant")

    def post(Merchant merchant) {
        def response = apiClient.post("/Merchant", merchant.to_json())
        response
    }

    def getAll() {
        def response = apiClient.get("/Merchant")
        response
    }

    def get(id) {
        def response = apiClient.get("/Merchant/${id}")
        response
    }
}