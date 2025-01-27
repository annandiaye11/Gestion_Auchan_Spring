package sn.api.gestionauchanspring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.api.gestionauchanspring.data.entities.Commande;

public interface CommandeService extends Service<Commande> {
    Page<Commande> GetAllCommandes(Pageable pageable);
}
