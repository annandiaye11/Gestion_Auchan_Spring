package sn.api.gestionauchanspring.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false, unique = true)
    private String code;
    @Column(length = 100, nullable = false)
    private String name;

}
