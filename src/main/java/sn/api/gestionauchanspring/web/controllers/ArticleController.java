package sn.api.gestionauchanspring.web.controllers;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.api.gestionauchanspring.data.entities.Article;
import sn.api.gestionauchanspring.web.dto.response.ArticleOneResponse;


@RequestMapping("api/v1/articles")
public interface ArticleController {

    @GetMapping("/")
    ResponseEntity<Page<ArticleOneResponse>> getAllArticles(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping("/one/{id}")
    ResponseEntity<ArticleOneResponse> getOne(@PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<Article> createArticle(@RequestBody Article article);

    @PutMapping("/update/{id}")
    ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article article);

}
