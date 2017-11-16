package galicia.express

import promotion.PromotionStatus

class Promotion {
    String name
    String image
    Date endDate
    String merchant_id
    String merchant_name
    String description
    Integer stock
    Float price
    Integer discount
    PromotionStatus promotionStatus
    Integer sells
    int rewards

    static constraints = {
        image(maxSize: 2000)
        price(nullable:false)
        promotionStatus(nullable: false)
        name(nullable: true)
        endDate(nullable: false)
        merchant_id(nullable: false)
        merchant_name(nullable: false)
        description(nullable: false)
        rewards(nullable: false)
        stock(nullable: false)
        discount(nullable: false)
        sells(nullable: true)
    }
}