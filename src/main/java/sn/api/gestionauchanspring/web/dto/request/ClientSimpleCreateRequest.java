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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
