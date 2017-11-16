package galicia.express

import buy.BuyType
import grails.converters.JSON
import utils.ChargeUtils

class NoClientController {
    NoClientService noClientService
    PromotionService promotionService
    NoClientPurchaseService noClientPurchaseService
    ChargeUtils chargeUtils = new ChargeUtils()

    def create() {
        NoClient noClient = noClientService.create(params)
        render noClient as JSON
    }

    def purchases(){
        def purchases = noClientPurchaseService.getNoClientSells(params.id)
        render purchases as JSON
    }

    def get() {
        def noClient = noClientService.getByDni(params.dni)

        if(!noClient){
            noClient = noClientService.get(params.dni)
        }

        if (noClient) {
            render noClient as JSON
        } else {
            def msg = [error: "That user is not registered"]
            render msg as JSON
        }
    }

    def buy() {
        params.rewards = 0
        def response = promotionService.buy(params)
        if (response.status == BuyType.Ok.name()) {
            def merchantId = response.merchantId
            NoClient noClient = noClientService.get(params.clientId)
            def purchaseId = chargeUtils.createChargesNoClient(response, noClient, merchantId)
            response.ticket = purchaseId
        }

        println response
        render response as JSON
    }
}
