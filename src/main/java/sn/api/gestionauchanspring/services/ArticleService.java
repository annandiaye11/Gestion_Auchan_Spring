package sn.api.gestionauchanspring.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import sn.api.gestionauchanspring.data.entities.Article;
import org.springframework.data.domain.Pageable;


@Service
public interface ArticleService {
    Page<Article> getAll(Pageable pageable);
    Article getById(Long id);
    Article create(Article article);
    Article update(Article article, Long id);
}
