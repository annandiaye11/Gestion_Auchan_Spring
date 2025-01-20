package sn.api.gestionauchanspring.web.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import sn.api.gestionauchanspring.data.entities.Article;
import sn.api.gestionauchanspring.data.repositories.ArticleRepository;
import sn.api.gestionauchanspring.services.ArticleService;
import sn.api.gestionauchanspring.web.controllers.ArticleController;
import sn.api.gestionauchanspring.web.dto.response.ArticleOneResponse;

public class ArticleControllerImpl  implements ArticleController {
    private final ArticleService articleService;

    public ArticleControllerImpl(ArticleService articleService) {
        this.articleService = articleService;
    }


    @Override
    public ResponseEntity<Page<ArticleOneResponse>> getAllArticles(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
            Pageable pageable = PageRequest.of(page, size);
            Page<Article> articles = articleService.getAll(pageable);
            Page<ArticleOneResponse> response = articles.map(ArticleOneResponse::new);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArticleOneResponse> getOne(Long id) {
        Article article = articleService.getById(id);
        return new ResponseEntity<>(new ArticleOneResponse(article), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Article> createArticle(Article article) {
        return null;
    }

    @Override
    public ResponseEntity<Article> updateArticle(Long id, Article article) {
        return null;
    }
}
