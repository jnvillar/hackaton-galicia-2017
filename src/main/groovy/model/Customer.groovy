package model

class Customer {
    String First_Name
    String Last_Name
    String Doc_Type
    String Doc_Number
    String birth_date
    String Mobile_Phone_Number
    String Email_Address
    String Third_Party_User_Id
    String Street_Number
    String Street_Name
    String City
    String State
    String Zip
    String Lat
    String Lng
    String Gender

    def to_json() {
        def map = [
                "First_Name"         : First_Name,
                "Last_Name"          : Last_Name,
                "Doc_Type"           : Doc_Type,
                "Doc_Number"         : Doc_Number,
                "birth_date"         : birth_date,
                "Mobile_Phone_Number": Mobile_Phone_Number,
                "Email_Address"      : Email_Address,
                "Third_Party_User_Id": Third_Party_User_Id,
                "Street_Number"      : Street_Number,
                "Street_Name"        : Street_Name,
                "City"               : city,
                "State"              : state,
                "Zip"                : zip,
                "Lat"                : lat,
                "Lng"                : lng,
                "Gender"             : gender
        ]

        return map
    }

}



