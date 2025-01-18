package sn.api.gestionauchanspring.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Category extends AbstractType {

    public Category(Long id, String code, String name) {
        super(id, code, name);
    }

    public Category() {
    }
}
