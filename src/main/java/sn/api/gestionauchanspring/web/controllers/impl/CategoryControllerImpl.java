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
import sn.api.gestionauchanspring.web.dto.response.CategoryAllResponse;
import sn.api.gestionauchanspring.web.dto.response.Response;
import sn.api.gestionauchanspring.web.dto.response.RestResponse;

import java.util.Map;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService categoryService;

    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<Map<String, Object>> getAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categories = categoryService.getAllCategories(pageable);
        Page<CategoryAllResponse> categoryAllResponses = categories.map(CategoryAllResponse::new);
        if (categories.hasContent()) {
            return new ResponseEntity<>(RestResponse.responsePaginate(
                    HttpStatus.OK,
                    categoryAllResponses.getContent(),
                    new int[categoryAllResponses.getTotalPages()],
                    categoryAllResponses.getNumber(),
                    categoryAllResponses.getTotalPages(),
                    categoryAllResponses.getTotalElements(),
                    categoryAllResponses.isFirst(),
                    categoryAllResponses.isLast(),
                    "CategoryAllResponse"
            ), HttpStatus.OK);
        }
        return new ResponseEntity<>( RestResponse.response(HttpStatus.NO_CONTENT, null, "no content") , HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getOne(Long id) {
        Category category = categoryService.getById(id);
        if(category == null) {
            return new ResponseEntity<>( RestResponse.response(HttpStatus.NO_CONTENT, null, "no content") , HttpStatus.NO_CONTENT);
        }
        CategoryAllResponse categoryAllResponse = new CategoryAllResponse(category);
        return new ResponseEntity<>(RestResponse.response(HttpStatus.OK, categoryAllResponse, "CategoryAllResponse"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Object>> createCategory(Category category) {
        CategoryAllResponse categoryAllResponse = new CategoryAllResponse(categoryService.create(category));
           return new ResponseEntity<>( RestResponse.response(HttpStatus.CREATED, categoryAllResponse, "CategoryAllResponse") , HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Map<String, Object>> updateCategory(Long id, Category category) {
        CategoryAllResponse categoryAllResponse = new CategoryAllResponse(categoryService.update(id, category));
        return  new ResponseEntity<>(RestResponse.response(HttpStatus.OK, categoryAllResponse, "CategoryAllResponse"), HttpStatus.OK);
    }
}
