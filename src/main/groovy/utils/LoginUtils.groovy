package utils

import clients.MerchantClient
import model.Merchant

class LoginUtils {
    MerchantClient merchantClient = new MerchantClient()

    def isRegistered(String store) {
        def merchants = merchantClient.getAll()
        def isRegistered = false
        def merchantId = null
        merchants.each { merchant ->
            if (merchant.Name.toUpperCase() == store.toUpperCase()) {
                isRegistered = true
                merchantId = merchant.Id
            }
        }

        return [
                registered: isRegistered,
                id        : merchantId
        ]
    }

    def register(Merchant merchant) {
        def response = merchantClient.post(merchant)
        response
    }
}
