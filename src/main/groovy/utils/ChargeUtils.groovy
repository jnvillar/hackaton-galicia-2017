package utils

import clients.AccountClient
import clients.PurchaseClient
import galicia.express.NoClientPurchase
import galicia.express.Promotion
import model.Account
import model.Purchase

class ChargeUtils {
    PurchaseClient purchaseClient = new PurchaseClient()
    AccountClient accountClient = new AccountClient()

    def createCharges(purchaseInfo, clientId, merchantId) {
        def accountId = updateClientAccount(purchaseInfo, clientId)
        def purchaseId = createAndPostPurchase(purchaseInfo, accountId, merchantId)
        purchaseId
    }

    def createChargesNoClient(purchaseInfo, noClient, merchantId) {
        updateNoClientAccount(purchaseInfo, noClient)
        def purchaseId = crateAndPostNoClientPurchase(purchaseInfo, noClient, merchantId)
        purchaseId
    }

    def crateAndPostNoClientPurchase(purchaseInfo, noClient, merchantId) {
        NoClientPurchase noClientPurchase = new NoClientPurchase()
        noClientPurchase.noClient = noClient
        noClientPurchase.description = "Promotion purchase"
        noClientPurchase.promotion = Promotion.findById(purchaseInfo.promotionId)
        noClientPurchase.merchantId = merchantId
        noClientPurchase.amount = purchaseInfo.paidAmount.toInteger()
        noClientPurchase.date = new Date()
        noClientPurchase.save(flush: true, failOnError: true)
        noClientPurchase.id
    }

    def updateNoClientAccount(purchaseInfo, noClient) {
        noClient.money = noClient.money - purchaseInfo.paidAmount.toInteger()
        noClient.save(flush: true, failOnError: true)
    }

    def createAndPostPurchase(purchaseInfo, clientId, merchantId) {
        Purchase purchase = createPurchase(purchaseInfo, clientId, merchantId)
        def response = purchaseClient.post(purchase)
        println response
        response.Id
    }

    def updateClientAccount(purchaseInfo, clientId) {
        Account clientAccount = new Account(accountClient.getSavingsAccount(clientId))
        clientAccount.Rewards = (clientAccount.Rewards.toInteger() - purchaseInfo.rewardsUsed.toInteger())
        //clientAccount.Balance = (clientAccount.Balance.toInteger() - purchaseInfo.paidAmount.toInteger())
        println accountClient.put(clientAccount)
        return clientAccount.Id
    }

    def createPurchase(purchaseInfo, accountId, merchantId) {
        def purchaseMap = [
                ticket    : purchaseInfo.ticket,
                merchantId: merchantId,
                accountId : accountId,
                amount    : purchaseInfo.paidAmount.toInteger(),
                purchaseId: purchaseInfo.purchaseId
        ]
        Purchase purchase = new Purchase(purchaseMap)
        println purchase.to_json()
        purchase
    }
}
