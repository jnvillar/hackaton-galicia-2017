package clients

import model.Account

class AccountClient {
    ApiClient apiClient = new ApiClient("https://api.bancogalicia.com.ar/apiAccount")

    def post(Account account) {
        def response = apiClient.post("/Account", account.to_json())
        response
    }

    def getAll() {
        def response = apiClient.get("/Account")
        response
    }

    def put(Account account) {
        def response = apiClient.put("/Account/${account.Id}", account.to_json())
        response
    }

    def get(id){
        def response = apiClient.get("/Account/${id}")
        response
    }

    def getSavingsAccount(id) {
        def accounts = apiClient.get("/customer/${id}/Account")
        def savingsAccount = accounts.find { account -> account.Type == "Savings" }
        savingsAccount
    }
}
