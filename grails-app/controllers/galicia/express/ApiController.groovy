package galicia.express

import buy.BuyType

import clients.PurchaseClient
import grails.converters.JSON
import utils.ChargeUtils

class ApiController {
    PromotionService promotionService
    ChargeUtils chargeUtils = new ChargeUtils()

    def getPromotionsByMerchantId() {
        def promotions = promotionService.getMerchantPromotionsByMerchantId(params.merchantId)
        render promotions as JSON
    }

    def getPromotionsByMerchantName() {
        def promotions = promotionService.getMerchantPromotionsByMerchantName(params.merchantName)
        render promotions as JSON
    }

    def getPromotions() {
        def promotions = promotionService.getPromotions()
        render promotions as JSON
    }

    def buy() {
        def response = promotionService.buy(params, 5)

        if (response.status == BuyType.Ok.name()) {
            def merchantId = response.merchantId
            def client = params.clientId
            def purchaseId = chargeUtils.createCharges(response, client, merchantId)
            response.ticket = purchaseId
        }
        render response as JSON
    }
}
