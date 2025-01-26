package sn.api.gestionauchanspring.web.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import sn.api.gestionauchanspring.data.entities.Article;

public class ArticleRequest {
    private Long id;
    private String code;
    private String name;
    private int prix;
    private int qteStock;

    public Article toEntity() {
        Article article = new Article();
        article.setCode(code);
        article.setName(name);
        article.setPrix(prix);
        article.setQteStock(qteStock);
        return article;
    }
}
