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
import sn.api.gestionauchanspring.web.dto.request.ClientSimpleCreateRequest;
import sn.api.gestionauchanspring.web.dto.response.ClientSimpleResponse;
import sn.api.gestionauchanspring.web.dto.response.ClientWithCommandResponse;
import sn.api.gestionauchanspring.web.dto.response.Response;
import sn.api.gestionauchanspring.web.dto.response.RestResponse;

import java.util.Map;

@RestController
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;

    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<Map<String, Object>> getClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> clients= clientService.findAll(pageable);
        Page<ClientSimpleResponse> clientsResponseDTO = clients.map(ClientSimpleResponse::new);
        if (clients.hasContent()) {
            return new ResponseEntity<>(
                    RestResponse.responsePaginate(
                            HttpStatus.OK,
                            clientsResponseDTO.getContent(),
                            new int[clientsResponseDTO.getTotalPages()] ,
                            clientsResponseDTO.getNumber(),
                            clientsResponseDTO.getTotalPages(),
                            clientsResponseDTO.getTotalElements(),
                            clientsResponseDTO.isFirst(),
                            clientsResponseDTO.isLast(),
                            "ClientSimpleResponse"
                    ),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>( RestResponse.response(HttpStatus.NO_CONTENT, null, "no content") , HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getClientById(Long id) {
        Client client = clientService.getById(id);
        if(client == null) {
            return new ResponseEntity<>(RestResponse.response(HttpStatus.NOT_FOUND, "Client not found", "error"), HttpStatus.NOT_FOUND);
        }
        ClientSimpleResponse clientSimpleResponse = new ClientSimpleResponse(client);

      return  new ResponseEntity<>(RestResponse.response(HttpStatus.OK, clientSimpleResponse, "ClientSimpleResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> createClient(ClientSimpleCreateRequest client) {
        Client clientResponse = clientService.create(client.toEntity());
        ClientSimpleResponse clientSimpleResponse = new ClientSimpleResponse(clientResponse);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.CREATED, clientSimpleResponse, "ClientSimpleResponse"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Map<String, Object>> updateClient(Long id, Client client) {
        Client clientResponse = clientService.update(id, client);
        ClientSimpleResponse clientSimpleResponse = new ClientSimpleResponse(client);
        return  new ResponseEntity<>(RestResponse.response(HttpStatus.OK, clientSimpleResponse, "ClientSimpleResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getClientWithCommandes(Long id) {
        Client client = clientService.getById(id);
        if(client == null) {
            return new ResponseEntity<>( RestResponse.response(HttpStatus.NO_CONTENT, null, "no content") , HttpStatus.NO_CONTENT);
        }
        ClientWithCommandResponse clientWithCommandResponse = new ClientWithCommandResponse(client);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, clientWithCommandResponse, "ClientWithCommandResponse"), HttpStatus.OK);
    }
}
