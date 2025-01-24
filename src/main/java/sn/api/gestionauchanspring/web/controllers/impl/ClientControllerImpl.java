package sn.api.gestionauchanspring.web.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.services.ClientService;
import sn.api.gestionauchanspring.web.controllers.ClientController;
import sn.api.gestionauchanspring.web.dto.response.Response;

@RestController
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;

    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<Response> getClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> clients= clientService.findAll(pageable);
        return new ResponseEntity<>(new Response("200", "CLients", clients), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getClientById(Long id) {
        Client client = clientService.getById(id);
        if(client == null) {
            return new ResponseEntity<>(new Response("404", "Client not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
      return  new ResponseEntity<>(new Response("200", "CLient", client), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Client> createClient(Client client) {
        return new ResponseEntity<>(clientService.create(client), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Client> updateClient(Long id, Client client) {
       return  new ResponseEntity<>(clientService.update(id, client), HttpStatus.OK);
    }
}
