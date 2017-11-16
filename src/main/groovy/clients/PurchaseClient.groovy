package clients

import model.Purchase

class PurchaseClient {
    ApiClient apiClient = new ApiClient("https://api.bancogalicia.com.ar/apiPurchase")

    def post(Purchase purchase) {
        def response = apiClient.post("/Purchase", purchase.to_json())
        response
    }

    def get(id) {
        def response = apiClient.get("/Purchase/${id}")
        response
    }

    def getSells(merchantId){
        def response = apiClient.get("/Merchant/${merchantId}/Purchase")
        if (response.getClass().toString() == "class org.grails.web.json.JSONObject"){
            response = []
        }
        response
    }
}
