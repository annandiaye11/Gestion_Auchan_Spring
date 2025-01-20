package sn.api.gestionauchanspring.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import sn.api.gestionauchanspring.data.entities.Category;

import java.util.List;

@Service
public interface CategoryService {
    Category create(Category categoryRequest);
    Category update(Long id, Category categoryRequest);
    Boolean delete(Long id);
    Category getById(Long id);
    List<Category> getAllCategories();
    Page<Category> getAllCategories(Pageable pageable);

}
