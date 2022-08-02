package ro.esolutions.testing.controllers

import org.springframework.http.ResponseEntity
import ro.esolutions.testing.services.ClientService
import spock.lang.Specification
import spock.lang.Subject

import static ro.esolutions.testing.testData.ClientData.aClient

class ClientControllerSpec extends Specification {

    def clientService = Mock(ClientService)

    @Subject
    def controller = new ClientController(clientService)

    def "get all clients"() {
        when:
        def response = controller.getAllClients()

        then:
        1 * clientService.getAllClients() >> [aClient()]
        0 * _

        response == ResponseEntity.ok([aClient()])
    }
}
