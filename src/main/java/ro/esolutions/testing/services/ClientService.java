package ro.esolutions.testing.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.esolutions.testing.controllers.models.ClientModel;
import ro.esolutions.testing.entities.Client;
import ro.esolutions.testing.mappers.ClientMapper;
import ro.esolutions.testing.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {

    @NonNull
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClients() {
        return clientRepository.findAll().stream()
                .map(ClientMapper::toModel)
                .collect(Collectors.toList());

    }

    public void saveOrUpdateClient(ClientModel clientModel) {
        Client client = clientModel.toEntity();
        clientRepository.save(client);

    }
}
