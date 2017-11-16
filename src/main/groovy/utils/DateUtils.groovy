package utils

class DateUtils {
    static parseFrontEndDate(String date) {
        return new Date().parse("yyyy-MM-dd-HH:mm", date.replace("T", "-"))
    }
}
