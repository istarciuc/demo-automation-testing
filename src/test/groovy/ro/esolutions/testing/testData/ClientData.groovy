package ro.esolutions.testing.testData

import ro.esolutions.testing.controllers.models.ClientModel
import ro.esolutions.testing.entities.Client

class ClientData {

    static Client aClient(Map overrides = [:]) {
        Map defaults = [
                id: 1000,
                name: 'George',
                isActive: true,
                type: Client.Type.YOUNG
        ]
        defaults << overrides
        new Client(defaults)
    }

    static ClientModel aClientModel(Map overrides = [:]) {
        Map defaults = [

                name: 'George',
                isActive: true,
                type: Client.Type.YOUNG
        ]
        defaults << overrides
        new ClientModel(defaults)
    }
}
