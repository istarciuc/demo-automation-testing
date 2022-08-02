package ro.esolutions.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolutions.testing.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
