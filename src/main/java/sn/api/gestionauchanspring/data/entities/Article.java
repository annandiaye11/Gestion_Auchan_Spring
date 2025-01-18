package sn.api.gestionauchanspring.data.entities;

import jakarta.persistence.Column;

public class Article extends AbstractType {
    private int prix;
    private int qteStock;

    public Article(Long id, String code, String name, int qteStock, int prix) {
        super(id, code, name);
        this.qteStock = qteStock;
        this.prix = prix;
    }
}
