package utils

class AnalyticsUtils {

    def countDates(sells) {
        Map<Date, Integer> dates = [:]
        def res = []

        sells.each { sell ->
            Date date = DateUtils.parseFrontEndDate(sell.Purchase_Date)
            date.clearTime()
            if (dates[date]) {
                dates[date] += 1
            } else {
                dates[date] = 1
            }
        }

        for (date in dates) {
            res.add([date.key.getTime(), date.value])
        }

        res = res.sort({ value -> value.get(0) })
        return res
    }

    def countDatesNoClient(sells) {
        Map<Date, Integer> dates = [:]
        def res = []

        sells.each { sell ->
            Date date = sell.date
            date.clearTime()
            if (dates[date]) {
                dates[date] += 1
            } else {
                dates[date] = 1
            }
        }

        for (date in dates) {
            res.add([date.key.getTime(), date.value])
        }

        res = res.sort({ value -> value.get(0) })
        return res
    }

}
