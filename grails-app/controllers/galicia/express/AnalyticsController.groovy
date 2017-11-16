package galicia.express

import clients.PurchaseClient
import utils.AnalyticsUtils

class AnalyticsController {
    PurchaseClient purchaseClient = new PurchaseClient()
    AnalyticsUtils analyticsUtils = new AnalyticsUtils()
    NoClientPurchaseService noClientPurchaseService

    def get() {
        def galiciaUsersSells = purchaseClient.getSells(session.merchantId)
        def otherClientsSells = noClientPurchaseService.getSells(session.merchantId)

        def galicia = analyticsUtils.countDates(galiciaUsersSells)
        def others = analyticsUtils.countDatesNoClient(otherClientsSells)

        render(view: "analytics", model: [galicia: galicia, others:others])
    }
}
