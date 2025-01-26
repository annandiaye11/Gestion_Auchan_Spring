package sn.api.gestionauchanspring.web.dto.response;

import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.data.entities.Commande;

import java.util.List;

public class ClientWithCommandResponse {
    private Long id;
    private String name;
    private String telephone;
    private List<CommandeSimpleResponse> commandes;

    public ClientWithCommandResponse(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.telephone = client.getTelephone();
        for (Commande commande: client.getCommandes()) {
            commandes.add(new CommandeSimpleResponse(commande));
        }
    }
}
