package galicia.express


class NoClientPurchaseService {

    def getSells(String merchantId) {
        def otherClientsSells =  NoClientPurchase.findAllByMerchantId(merchantId)
        if(!otherClientsSells) otherClientsSells = []
        return otherClientsSells
    }

    def getNoClientSells(clientId) {
        return NoClientPurchase.findAllByNoClient(NoClient.findById(clientId))
    }
}
