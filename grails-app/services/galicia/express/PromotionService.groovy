package galicia.express

import buy.BuyType
import promotion.PromotionStatus
import utils.DateUtils

class PromotionService {

    def getMerchantPromotionsByMerchantName(String merchantName) {
        Promotion.findAllByMerchant_nameAndPromotionStatusAndEndDateGreaterThan(merchantName, PromotionStatus.Active, new Date())
    }

    def getOldMerchantPromotionsByMerchantName(String merchantName) {
        Promotion.findAllByMerchant_nameAndPromotionStatusAndEndDateLessThan(merchantName, PromotionStatus.Active, new Date())
    }

    def getPromotions() {
        Promotion.findAllByPromotionStatusAndEndDateGreaterThan(PromotionStatus.Active, new Date())
    }

    def getMerchantPromotionsByMerchantId(merchantId) {
        Promotion.findAllByMerchant_id(merchantId)
    }

    def get(id) {
        Promotion.findById(id)
    }

    def delete(id) {
        Promotion.findById(id).delete(flush: true, failOnError: true)
    }

    def create(Map parameters) {
        Promotion promotion = Promotion.findOrCreateById(parameters.promotionId)
        promotion.merchant_name = parameters.merchant_name
        promotion.name = parameters.name
        promotion.image = parameters.image
        promotion.rewards = parameters.rewards.toInteger()
        promotion.description = parameters.description
        promotion.merchant_id = parameters.merchantId
        promotion.endDate = DateUtils.parseFrontEndDate(parameters.endDate)
        promotion.stock = parameters.stock.toInteger()
        promotion.promotionStatus = PromotionStatus.Active
        promotion.price = parameters.price.toFloat()
        promotion.discount = parameters.discount.toInteger()
        promotion.sells = 0
        promotion.save(flush: true, failOnError: true)
        promotion
    }

    def buy(Map params, Integer galiciaDiscount = 0) {
        Promotion promotion = Promotion.findById(params.promotionId)

        if (!promotion) return [status: BuyType.Promotion_Not_Found]
        if (promotion.stock == 0) return [status: BuyType.No_Stock]
        if (promotion.endDate < new Date()) return [status: BuyType.Promotion_Ended.name() + " ${promotion.endDate}"]

        Integer userRewards = params.rewards.toInteger()
        Integer promotionRewards = promotion.rewards
        Integer extraDiscount = (userRewards / promotionRewards)
        Integer rewardsUsed = userRewards
        Integer rewardsNotUsed = 0
        Integer promotionDiscount = promotion.discount
        Integer effectiveDiscount = Math.min(100, promotionDiscount + extraDiscount + galiciaDiscount)

        if (effectiveDiscount == 100) {
            rewardsUsed = (100 - promotionDiscount) * promotionRewards
            rewardsNotUsed = userRewards - rewardsUsed
        }

        Float price = promotion.price
        Float paidAmount = 0.0
        Float userMoney = params.money.toFloat()
        String status

        price = price - (price * effectiveDiscount / 100)

        if (userMoney >= price) {
            promotion.stock -= 1
            if(promotion.stock == 0){
                promotion.endDate = new Date()
            }
            promotion.sells += 1
            status = BuyType.Ok.name()
            promotion.save(flush: true, failOnError: true)
            paidAmount = price
        } else {
            status = BuyType.Not_Enough_Money.name()
            rewardsNotUsed = 0
            rewardsUsed = 0
        }

        return [
                status        : status,
                paidAmount    : paidAmount,
                discount      : effectiveDiscount,
                rewardsUsed   : rewardsUsed,
                rewardsNotUsed: rewardsNotUsed,
                merchantId    : promotion.merchant_id,
                promotionId    : promotion.id
        ]
    }
}

