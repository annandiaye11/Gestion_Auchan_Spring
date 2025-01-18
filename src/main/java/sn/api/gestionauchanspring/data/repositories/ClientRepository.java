package sn.api.gestionauchanspring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.api.gestionauchanspring.data.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
