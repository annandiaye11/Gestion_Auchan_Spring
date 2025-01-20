package sn.api.gestionauchanspring.web.controllers.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.api.gestionauchanspring.data.entities.Category;
import sn.api.gestionauchanspring.services.CategoryService;
import sn.api.gestionauchanspring.web.controllers.CategoryController;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService categoryService;

    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<Page<Category>> getAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categories = categoryService.getAllCategories(pageable);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> getOne(Long id) {
        return new ResponseEntity<>(categoryService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> createCategory(Category category) {
       return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Category> updateCategory(Long id, Category category) {
        return  new ResponseEntity<>(categoryService.update(id, category), HttpStatus.OK);
    }
}
