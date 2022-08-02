package ro.esolutions.testing.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import ro.esolutions.testing.controllers.models.ClientModel
import ro.esolutions.testing.repository.ClientRepository
import spock.lang.Specification

import static ro.esolutions.testing.testData.ClientData.aClientModel

@SqlGroup(
        @Sql(value = '/sql/clients.sql', executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientControllerIT extends Specification {

    @Autowired
    TestRestTemplate restTemplate

    @Autowired
    ClientRepository clientRepository


    def 'gel all clients'() {
        given:
        def url = '/client/all'

        when:
        def result = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<ClientModel>>() {})

        then:
        result.statusCode == HttpStatus.OK
        result.getBody() == [aClientModel()]
    }


    def 'save new client'() {
        given:
        def clientModel = aClientModel(name: 'George-Mihai')

        when:
        def result = restTemplate.postForEntity('/client', clientModel, null)

        then:
        result.statusCode == HttpStatus.OK

        and:
        clientRepository.findAll().size() == 2
        clientRepository.findById(1L).get().name == 'George-Mihai'
    }


    def 'save invalid client'() {
        given:
        def clientModel = aClientModel(name: '')

        when:
        def result = restTemplate.postForEntity('/client', clientModel, null)

        then:
        result.statusCode == HttpStatus.BAD_REQUEST
        result.getBody() == null

        and:
        clientRepository.findAll().size() == 1
    }

}
