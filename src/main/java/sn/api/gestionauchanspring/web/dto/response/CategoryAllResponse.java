package sn.api.gestionauchanspring.web.dto.response;

import sn.api.gestionauchanspring.data.entities.Category;

public class CategoryAllResponse {
    private Long id;
    private String code;
    private String name;

    public CategoryAllResponse(Category category) {
        this.id = category.getId();
        this.code = category.getCode();
        this.name = category.getName();
    }
}
