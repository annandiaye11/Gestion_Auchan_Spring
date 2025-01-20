package sn.api.gestionauchanspring.web.dto.response;


import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;
import sn.api.gestionauchanspring.data.entities.Article;

public class ArticleAllResponse {

    private Long id;
    private String code;
    private String name;
    private int prix;
    private int qteStock;


    public ArticleAllResponse(Article article) {
        this.id = article.getId();
        this.code = article.getCode();
        this.name = article.getName();
        this.prix = article.getPrix();
        this.qteStock = article.getQteStock();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

}
