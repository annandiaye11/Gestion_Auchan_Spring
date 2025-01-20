package sn.api.gestionauchanspring.web.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.services.ClientService;
import sn.api.gestionauchanspring.web.controllers.ClientController;

public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;

    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<Page<Client>> getClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> clients= clientService.findAll(pageable);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Client> getClientById(Long id) {
      return  new ResponseEntity<>(clientService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Client> createClient(Client client) {
        return new ResponseEntity<>(clientService.create(client), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Client> updateClient(Long id, Client client) {
       return  new ResponseEntity<>(clientService.update(client), HttpStatus.OK);
    }
}
