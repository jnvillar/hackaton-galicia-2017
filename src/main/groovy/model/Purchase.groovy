package model

class Purchase {
    String Merchant_Id
    String Player_Id
    String Status
    Date Purchase_Date
    String Amount
    String Medium
    String Description
    String Type

    def to_json() {

        def map = [
                Merchant_Id  : Merchant_Id,
                Player_Id    : Player_Id,
                Status       : Status,
                Purchase_Date: Purchase_Date,
                Amount       : Amount,
                Medium       : Medium,
                Description  : Description,
                Type         : Type
        ]

        return map
    }

    Purchase(params) {
        Merchant_Id = params.merchantId
        Player_Id = params.accountId
        Status = "Realizada"
        Purchase_Date = new Date()
        Amount = params.amount
        Medium = "Balance"
        Description = "${params.promotionId}"
        Type = "Balance"
    }


}
