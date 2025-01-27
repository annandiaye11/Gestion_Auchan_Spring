package sn.api.gestionauchanspring.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.api.gestionauchanspring.data.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    Page<Commande> findByClientId(int clientId, Pageable pageable);
    @Override
    Page<Commande> findAll(Pageable pageable);
}
