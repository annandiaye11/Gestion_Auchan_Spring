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
import sn.api.gestionauchanspring.web.dto.response.Response;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService categoryService;

    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<Response> getAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categories = categoryService.getAllCategories(pageable);
        return new ResponseEntity<>(new Response("200", "Categories", categories), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getOne(Long id) {
        Category category = categoryService.getById(id);
        if(category == null) {
            return new ResponseEntity<>(new Response("404", "Category not found", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Response("200", "Category", categoryService.getById(id)), HttpStatus.OK);
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
