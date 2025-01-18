package sn.api.gestionauchanspring.services;

import sn.api.gestionauchanspring.data.entities.Category;

import java.util.List;

public interface CategoryService {
    Category create(Category categoryRequest);
    Category update(Long id, Category categoryRequest);
    Boolean delete(Long id);
    Category getById(Long id);
    List<Category> getAllCategories();

}
