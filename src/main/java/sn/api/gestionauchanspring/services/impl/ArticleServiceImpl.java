package sn.api.gestionauchanspring.services.impl;

import jakarta.persistence.Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.api.gestionauchanspring.data.entities.Article;
import sn.api.gestionauchanspring.data.repositories.ArticleRepository;
import sn.api.gestionauchanspring.services.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Page<Article> getAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Article getById(Long id) {
       return articleRepository.findById(id).orElse(null);
    }

    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article update(Article data, Long id) {
       var article = articleRepository.findById(id).orElse(null);
       if(article == null) {
           return null;
       }
       article.setName(data.getName());
       article.setPrix(data.getPrix());
       article.setQteStock(data.getQteStock());
       article.setCode(data.getCode());
       article.setCategory(data.getCategory());
       return articleRepository.save(article);
    }
}
