package sn.api.gestionauchanspring.web.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.api.gestionauchanspring.data.entities.Article;
import sn.api.gestionauchanspring.web.dto.response.Response;
import sn.api.gestionauchanspring.web.dto.response.RestResponse;

import java.util.Map;


@RequestMapping("api/v1/articles")
public interface ArticleController {

    @GetMapping("/")
    ResponseEntity<Map<String, Object>> getAllArticles(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping("/one/{id}")
    ResponseEntity<Map<String, Object>> getOne(@PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<Map<String, Object>> createArticle(@RequestBody Article article);

    @PutMapping("/update/{id}")
    ResponseEntity<Map<String, Object>> updateArticle(@PathVariable Long id, @RequestBody Article article);

}
