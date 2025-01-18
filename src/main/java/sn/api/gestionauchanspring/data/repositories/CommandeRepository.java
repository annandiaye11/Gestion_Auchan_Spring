package sn.api.gestionauchanspring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.api.gestionauchanspring.data.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
