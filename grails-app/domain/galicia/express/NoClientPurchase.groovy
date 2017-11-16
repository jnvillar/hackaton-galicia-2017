package galicia.express

class NoClientPurchase {

    Integer amount
    NoClient noClient
    Promotion promotion
    String merchantId
    String description
    Date date

    static constraints = {
        description(nullable: true)
        date(nullable: true)
    }
}
