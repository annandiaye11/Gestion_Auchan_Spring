package sn.api.gestionauchanspring.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.api.gestionauchanspring.data.entities.Article;
import sn.api.gestionauchanspring.data.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Override
    Page<Client> findAll(Pageable pageable);
}
