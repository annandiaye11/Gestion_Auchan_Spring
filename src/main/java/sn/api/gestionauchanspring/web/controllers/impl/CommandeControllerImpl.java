package sn.api.gestionauchanspring.web.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.data.entities.Commande;
import sn.api.gestionauchanspring.services.ClientService;
import sn.api.gestionauchanspring.services.CommandeService;
import sn.api.gestionauchanspring.web.controllers.CommandeController;
import sn.api.gestionauchanspring.web.dto.request.CommandeRequest;
import sn.api.gestionauchanspring.web.dto.response.CommandeSimpleResponse;
import sn.api.gestionauchanspring.web.dto.response.RestResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommandeControllerImpl implements CommandeController {
    private final CommandeService commandeService;
    private final ClientService clientService;
    public CommandeControllerImpl(CommandeService commandeService, ClientService clientService) {
        this.commandeService = commandeService;
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAllCommandes(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Commande> commandes = commandeService.GetAllCommandes(pageable);
        Page<CommandeSimpleResponse> commandesSimpleRsp = commandes.map(comm -> new CommandeSimpleResponse(comm));

        if (commandesSimpleRsp.hasContent()) {
            return  new ResponseEntity<>(
                    RestResponse.responsePaginate(
                            HttpStatus.OK,
                            commandesSimpleRsp.getContent(),
                            new int [commandesSimpleRsp.getTotalPages()],
                            commandesSimpleRsp.getNumber(),
                            commandesSimpleRsp.getTotalPages(),
                            commandesSimpleRsp.getTotalElements(),
                            commandesSimpleRsp.isFirst(),
                            commandesSimpleRsp.isLast(),
                            "CommandesSimpleResponse"
                    ),
                    HttpStatus.OK
                    );
        }
        return new ResponseEntity<>( RestResponse.response(HttpStatus.NO_CONTENT, null, "no content") , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getCommandeById(Long id) {
       Commande commande = commandeService.getById(id);
       if (commande == null) {
           return new ResponseEntity<>( RestResponse.response(HttpStatus.NO_CONTENT, null, "no content") , HttpStatus.OK);
        }
       return  new ResponseEntity<>(RestResponse.response(HttpStatus.OK, new CommandeSimpleResponse(commande), "Commande") , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> createCommande(CommandeRequest commande, Long id) {
        Client client = clientService.getById(id);
        if (client == null) {
            return new ResponseEntity<>( RestResponse.response(HttpStatus.NO_CONTENT, null, "no client") , HttpStatus.OK);
        }
        Commande commande1 = commandeService.create(commande.toEntity(client));
        return new ResponseEntity<>(RestResponse.response(HttpStatus.CREATED, new CommandeSimpleResponse(commande1), "Commande") , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> updateCommande(Long id, Commande commande) {
       Commande commande1 = commandeService.getById(id);
       if (commande1 == null) {
           return new ResponseEntity<>( RestResponse.response(HttpStatus.NO_CONTENT, null, "no content") , HttpStatus.OK);
       }
       commandeService.update(id,commande);
       return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, commande, "Commande") , HttpStatus.OK);

    }
}
