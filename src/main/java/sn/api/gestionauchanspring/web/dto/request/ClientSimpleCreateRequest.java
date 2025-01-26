package sn.api.gestionauchanspring.web.dto.request;

import jakarta.persistence.*;
import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.data.entities.Commande;

import java.util.HashSet;
import java.util.Set;

public class ClientSimpleCreateRequest {
    private Long id;
    private String name;
    private String telephone;

    public Client toEntity() {
        Client client = new Client();
        client.setName(name);
        client.setTelephone(telephone);
        return client;
    }

}
