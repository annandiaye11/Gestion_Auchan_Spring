package sn.api.gestionauchanspring.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sn.api.gestionauchanspring.data.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Override
    Page<Article> findAll(Pageable pageable);
}
