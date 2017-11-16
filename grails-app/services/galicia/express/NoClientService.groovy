package galicia.express

class NoClientService {

    def create(Map params) {
        NoClient noClient = new NoClient()
        noClient.name = params.name
        noClient.lastName = params.lastName
        noClient.dni = params.dni
        noClient.money = params.Balance.toInteger()
        noClient.save(flush:true, failOnError:true)
        noClient
    }

    def getByDni(String dni){
        NoClient noClient = NoClient.findByDni(dni)
        return noClient
    }

    def get(String id){
        NoClient noClient = NoClient.findById(id)
        return noClient
    }

}
