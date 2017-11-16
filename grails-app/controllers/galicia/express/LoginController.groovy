package galicia.express

import grails.converters.JSON
import model.Merchant
import utils.LoginUtils

class LoginController {
    LoginUtils loginUtils = new LoginUtils()

    def loginForm() {
        render(view: "login")
    }

    def registerForm() {
        render(view: "register")
    }

    def register() {
        Merchant merchant = new Merchant(params)
        def response = loginUtils.register(merchant)
        render(view:"login", model: [msg: response])
    }

    def login() {
        def merchantInfo = loginUtils.isRegistered(params.merchantName)

        if (merchantInfo.registered){
            session.setMaxInactiveInterval(3600)
            session.user = params.merchantName.toUpperCase()
            session.merchantId = merchantInfo.id
            redirect(controller: "index", action: "index")
        }

        render(view: "login", model: [msg:"No registered"])
    }

    def logout(){
        session.user = null
        redirect(url:"/login")
    }
}
