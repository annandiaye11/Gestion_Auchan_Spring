package sn.api.gestionauchanspring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.api.gestionauchanspring.data.entities.Category;
import sn.api.gestionauchanspring.data.entities.Client;

import java.util.List;

public interface ClientService extends Service<Client> {
    Page<Client> findAll(Pageable pageable);

}
