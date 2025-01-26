package sn.api.gestionauchanspring.web.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sn.api.gestionauchanspring.data.entities.Article;
import sn.api.gestionauchanspring.services.ArticleService;
import sn.api.gestionauchanspring.web.controllers.ArticleController;
import sn.api.gestionauchanspring.web.dto.response.ArticleAllResponse;
import sn.api.gestionauchanspring.web.dto.response.ArticleOneResponse;
import sn.api.gestionauchanspring.web.dto.response.Response;
import sn.api.gestionauchanspring.web.dto.response.RestResponse;

import java.util.Map;

@RestController
public class ArticleControllerImpl  implements ArticleController {
    private final ArticleService articleService;

    public ArticleControllerImpl(ArticleService articleService) {
        this.articleService = articleService;
    }


    @Override
    public ResponseEntity<Map<String, Object>> getAllArticles(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Article> articles = articleService.getAll(pageable);
        Page<ArticleAllResponse> response = articles.map(ArticleAllResponse::new);
        if (response.hasContent()) {
            return new ResponseEntity<>(
                    RestResponse.responsePaginate(
                            HttpStatus.OK,
                            response.getContent(),
                            new int[response.getTotalPages()],
                            response.getNumber(),
                            response.getTotalPages(),
                            response.getTotalElements(),
                            response.isFirst(),
                            response.isLast(),
                            "ArticleAllResponse"
                    ),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>( RestResponse.response(HttpStatus.NO_CONTENT, null, "no content") , HttpStatus.NO_CONTENT);

    }

    @Override
    public ResponseEntity<Map<String, Object>> getOne(Long id) {
        Article article = articleService.getById(id);
        if (article == null) {
            return new ResponseEntity<>( RestResponse.response(HttpStatus.NOT_FOUND, null, "no found") , HttpStatus.NOT_FOUND);
        }
        ArticleOneResponse articleOneResponse = new ArticleOneResponse(article);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, articleOneResponse, "ArticleOneResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> createArticle(Article article) {
        Article articleCreated = articleService.create(article);
        ArticleOneResponse articleOneResponse = new ArticleOneResponse(articleCreated);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.CREATED, articleOneResponse, "ArticleOneResponse"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Map<String, Object>> updateArticle(Long id, Article article) {
        Article articleUpdated = articleService.update(article, id);
        ArticleOneResponse articleOneResponse = new ArticleOneResponse(articleUpdated);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, articleOneResponse, "ArticleOneResponse"), HttpStatus.OK);
    }
}
