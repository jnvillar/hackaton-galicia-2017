package galicia.express

import clients.MerchantClient


class LoginInterceptor {

    LoginInterceptor() {
        match(controller: "index", action: "*")
        match(controller: "promotion", action: "*")
        match(controller: "analytics", action: "*")
    }

    boolean before() {
        if (!session.user) {
            redirect(url: "/login")
            return false
        }
        return true
    }

    boolean after() { true }

    void afterView() {}

}
