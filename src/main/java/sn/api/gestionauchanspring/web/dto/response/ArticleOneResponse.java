package sn.api.gestionauchanspring.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sn.api.gestionauchanspring.data.entities.Article;
import sn.api.gestionauchanspring.data.entities.Category;

public class ArticleOneResponse {

    private Long id;
    private String code;
    private String name;
    private int prix;
    private int qteStock;

    public ArticleOneResponse(Article article) {
        this.id = article.getId();
        this.code = article.getCode();
        this.name = article.getName();
        this.prix = article.getPrix();
        this.qteStock = article.getQteStock();
    }

    public ArticleOneResponse() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }


}
