package sn.api.gestionauchanspring.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
public class Article extends AbstractType {
    private int prix;
    private int qteStock;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    Category category;

    public Article(Long id, String code, String name, int qteStock, int prix) {
        super(id, code, name);
        this.qteStock = qteStock;
        this.prix = prix;
    }

    public Article() {

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
