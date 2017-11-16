class UrlMappings {

    static mappings = {
        "/promotion/get/$id" (controller: "promotion"){
            action = [GET:"get"]
        }

        "/promotion/create" (controller: "promotion"){
            action = [GET:"form", POST:"create"]
        }

        "/promotion/delete"(controller: "promotion"){
            action = [GET: "delete"]
        }

        "/promotion/edit/${promotionId}" (controller: "promotion"){
            action = [GET:"editForm", POST:"edit"]
        }

        "/sells/${merchantId}"(controller: "promotion"){
            action = [GET:"getSells"]
        }

        "/analytics/${merchantId}"(controller: "analytics"){
            action = [GET:"get"]
        }

        "/register"(controller: "login"){
            action = [GET: "registerForm", POST: "register"]
        }

        "/login"(controller: "login"){
            action = [GET: "loginForm", POST: "login"]
        }

        "/" (controller: "index"){
            action = [GET:"index"]
        }

        "/logout"(controller: "login"){
            action = [GET: "logout"]
        }

        "/api/promotions" (controller: "api"){
            action = [GET:"getPromotionsByMerchantName"]
        }

        "/api/allPromotions" (controller: "api"){
            action = [GET:"getPromotions"]
        }

        "/api/buy"(controller: "api"){
            action = [POST: "buy"]
        }

        "/api/noClient/create" (controller: "noClient") {
            action = [POST: "create"]
        }

        "/api/noClient/${dni}" (controller: "noClient") {
            action = [GET: "get"]
        }

        "/api/noClient/buy" (controller: "noClient") {
            action = [POST: "buy"]
        }

        "/api/noClient/purchases/${id}" (controller: "noClient") {
            action = [GET: "purchases"]
        }

        "/api/merchants"(controller: "api"){
            action = [GET: "merchants"]
        }

        "404"(view:'/error')
        "500"(view:'/error')
    }
}
