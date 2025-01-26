package sn.api.gestionauchanspring.web.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.api.gestionauchanspring.data.entities.Category;
import sn.api.gestionauchanspring.web.dto.response.Response;

import java.util.Map;

@RestController
@RequestMapping("api/v1/categories")
public interface CategoryController {

    @GetMapping("")
    ResponseEntity<Map<String, Object>> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping("/{id}")
    ResponseEntity<Map<String, Object>> getOne(@PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<Map<String, Object>> createCategory(@RequestBody Category category);

    @PutMapping("/update/{id}")
    ResponseEntity<Map<String, Object>> updateCategory(@PathVariable Long id, @RequestBody Category category);
}
