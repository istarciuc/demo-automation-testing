package ro.esolutions.testing.mappers;

import ro.esolutions.testing.controllers.models.ClientModel;
import ro.esolutions.testing.entities.Client;

public final class ClientMapper {

    private ClientMapper() {}

    public static ClientModel toModel(final Client client) {
        return ClientModel.builder()
                .name(client.getName())
                .type(client.getType())
                .isActive(client.getIsActive())
                .build();
    }
}
