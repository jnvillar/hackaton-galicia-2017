package galicia.express

import clients.AccountClient
import clients.CustomerClient
import clients.PurchaseClient

class PromotionController {
    PromotionService promotionService
    PurchaseClient purchaseClient = new PurchaseClient()
    CustomerClient customerClient = new CustomerClient()
    AccountClient accountClient = new AccountClient()
    NoClientPurchaseService noClientPurchaseService

    def form() {
        render(view: "form")
    }

    def get() {
        promotionService.get(params.id)
    }

    def getSells() {
        def sells = purchaseClient.getSells(params.merchantId)

        if (sells.size() > 12) {
            sells = sells.subList(sells.size() - 12, sells.size())
        }

        sells = sells.reverse()

        def clientNames = []
        sells.each { sell ->
            def clientAccount = accountClient.get(sell.Player_Id)
            clientNames.add(customerClient.getClientName(clientAccount.Customer_Id))
            /* hitting the api to fast kills it */
            sleep(50)
        }

        def noGaliciaSells = noClientPurchaseService.getSells(params.merchantId)
        noGaliciaSells = noGaliciaSells.reverse()

        render(view: "sells", model: [sells: sells, clients: clientNames, noGaliciaSells: noGaliciaSells])
    }

    def editForm() {
        Promotion promotion = promotionService.get(params.promotionId)
        render(view: "edit", model: [promotion: promotion])
    }

    def edit() {
        params.merchantId = session.merchantId
        params.merchant_name = session.user
        promotionService.create(params)
        redirect(url: "/")
    }

    def create() {
        params.promotionId = -1
        params.merchant_name = session.user
        params.merchantId = session.merchantId
        promotionService.create(params)
        redirect(url: "/")
    }

    def delete() {
        promotionService.delete(params.promotionId)
        redirect(url: "/")
    }
}
