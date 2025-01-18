package sn.api.gestionauchanspring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.api.gestionauchanspring.data.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
