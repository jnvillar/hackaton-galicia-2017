package galicia.express

class IndexController {
    PromotionService promotionService

    def index() {
        def oldPromotions = promotionService.getOldMerchantPromotionsByMerchantName(session.user)
        def promotions = promotionService.getMerchantPromotionsByMerchantName(session.user)
        render(view: "index", model: [promotions:promotions, oldPromotions:oldPromotions])
    }
}
