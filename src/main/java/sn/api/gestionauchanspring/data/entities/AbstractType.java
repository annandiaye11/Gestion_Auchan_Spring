package sn.api.gestionauchanspring.data.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class AbstractType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false, unique = true)
    private String code;
    @Column(length = 100, nullable = false)
    private String name;

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

    public AbstractType(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public AbstractType() {
    }
}
