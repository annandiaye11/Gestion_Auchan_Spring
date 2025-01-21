package sn.api.gestionauchanspring.web.dto.response;

import jakarta.persistence.Column;
import sn.api.gestionauchanspring.data.entities.Client;

public class ClientSimpleResponse {
    private Long id;
    private String name;
    private String telephone;

    public ClientSimpleResponse(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.telephone = client.getTelephone();
    }

}
