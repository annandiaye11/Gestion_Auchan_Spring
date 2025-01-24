package sn.api.gestionauchanspring.web.controllers;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.api.gestionauchanspring.data.entities.Category;
import sn.api.gestionauchanspring.web.dto.response.Response;

@RestController
@RequestMapping("api/v1/categories")
public interface CategoryController {

    @GetMapping("")
    ResponseEntity<Response> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping("/{id}")
    ResponseEntity<Response> getOne(@PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<Category> createCategory(@RequestBody Category category);

    @PutMapping("/update/{id}")
    ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category);
}
