package ro.esolutions.testing.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import spock.lang.Specification

import static ro.esolutions.testing.testData.ClientData.aClient

@SqlGroup(
        @Sql(value = '/sql/clients.sql', executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientRepositoryIT extends Specification {

    @Autowired
    ClientRepository clientRepository;

    def "get all clients"() {
        expect:
        clientRepository.findAll() == [aClient()]

    }
}
