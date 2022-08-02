package ro.esolutions.testing.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.esolutions.testing.entities.Client;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientModel {

    private Long id;

    @NotBlank
    private String name;

    private Boolean isActive;

    private Client.Type type;

    public Client toEntity() {
        return new Client(id, name, isActive, type);
    }
}
