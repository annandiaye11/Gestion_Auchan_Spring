package sn.api.gestionauchanspring.web.dto.response;

import jakarta.persistence.Column;
import lombok.NoArgsConstructor;
import sn.api.gestionauchanspring.data.entities.Client;

@NoArgsConstructor
public class ClientSimpleResponse {
    private Long id;
    private String name;
    private String telephone;

    public ClientSimpleResponse(Client client) {

        this.id = client.getId();
        this.name = client.getName();
        this.telephone = client.getTelephone();
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
