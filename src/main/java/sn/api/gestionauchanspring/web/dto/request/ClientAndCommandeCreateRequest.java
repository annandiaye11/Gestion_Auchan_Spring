package sn.api.gestionauchanspring.web.dto.request;

import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.data.entities.Commande;

import java.util.HashSet;
import java.util.Set;

public class ClientAndCommandeCreateRequest {
    private Long id;
    private String name;
    private String telephone;
    private Set<Commande> commandes = new HashSet<>();

    public Client toEntity() {
        Client client = new Client();
        client.setName(name);
        client.setTelephone(telephone);
        client.setCommandes(commandes);
        return client;
    }
}
