package model

class Merchant {
    String Name
    String Category
    String Street_Number
    String Street_Name
    String City
    String State
    String Zip
    String Lat
    String Lng

    Merchant(params) {
        Name = params.name
        Category = params.category
        Street_Number = params.streetNumber
        Street_Name = params.streetName
        City = params.city
        State = params.state
        Zip = params.zip
        Lat = params.lat
        Lng = params.lng
    }

    def to_json() {
        def map = [
                "Name"         : Name,
                "Category"     : Category,
                "Street_Number": Street_Number,
                "Street_Name"  : Street_Name,
                "City"         : City,
                "State"        : State,
                "Zip"          : Zip,
                "Lat"          : Lat,
                "Lng"          : Lng
        ]

        return map
    }
}
