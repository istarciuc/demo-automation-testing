package ro.esolutions.testing.controllers;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.esolutions.testing.controllers.models.ClientModel;
import ro.esolutions.testing.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    @NonNull
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<ClientModel>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping()
    public void saveClient(@RequestBody @Validated final ClientModel clientModel) {
        clientService.saveOrUpdateClient(clientModel);
    }
}
