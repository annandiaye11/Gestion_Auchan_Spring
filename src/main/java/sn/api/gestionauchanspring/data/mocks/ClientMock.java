package sn.api.gestionauchanspring.data.mocks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.services.ClientService;

@Component
@Order(1)
public class ClientMock implements CommandLineRunner {
    private final ClientService clientService;

    public ClientMock(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Client client = new Client();
            client.setName("Client " + i);
            client.setTelephone(String.valueOf("77 700 70 1"+i));
            clientService.create(client);
        }
    }
}
