package sn.api.gestionauchanspring.web.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ArticleRequest {
    private Long id;
    @NotNull
    private String code;

    @NotNull
    private String name;
    private int prix;
    private int qteStock;
}
