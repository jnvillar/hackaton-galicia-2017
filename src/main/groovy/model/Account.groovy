package model

class Account {
    String Id
    String Type
    String Nickname
    String Rewards
    String Balance
    String Account_Number
    String Customer_Id

    def to_json() {

        def map = [
                Id            : Id,
                Type          : Type,
                Nickname      : Nickname,
                Rewards       : Rewards,
                Balance       : Balance,
                Account_Number: Account_Number,
                Customer_Id   : Customer_Id
        ]

        return map

    }

    Account(params){
        Id = params.Id
        Type = params.Type
        Nickname = params.Nickname
        Rewards = params.Rewards
        Balance = params.Balance
        Account_Number = params.Account_Number
        Customer_Id = params.Customer_Id
    }
}
