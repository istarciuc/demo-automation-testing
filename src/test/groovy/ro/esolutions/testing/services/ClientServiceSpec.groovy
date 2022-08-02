package ro.esolutions.testing.services

import ro.esolutions.testing.repository.ClientRepository
import spock.lang.Specification
import spock.lang.Subject

import static ro.esolutions.testing.testData.ClientData.aClient
import static ro.esolutions.testing.testData.ClientData.aClientModel

class ClientServiceSpec extends Specification {

    def clientRepository = Mock(ClientRepository)

    @Subject
    def clientService = new ClientService(clientRepository)

    def "get all client"() {
        when:
        def result = clientService.getAllClients()

        then:
        1 * clientRepository.findAll() >> [aClient()]
        0 * _

        and:
        result == [aClientModel()]
    }

}
