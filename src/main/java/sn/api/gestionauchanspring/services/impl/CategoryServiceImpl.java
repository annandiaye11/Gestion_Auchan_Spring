package sn.api.gestionauchanspring.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sn.api.gestionauchanspring.data.entities.Category;
import sn.api.gestionauchanspring.data.repositories.CategoryRepository;
import sn.api.gestionauchanspring.services.CategoryService;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category categoryRequest) {
        return categoryRepository.save(categoryRequest);
    }

    @Override
    public Category update(Long id, Category categoryRequest) {
        Category cat = categoryRepository.findById(id).orElse(null);
        if (cat != null) {
            cat.setCode(categoryRequest.getCode());
            cat.setName(categoryRequest.getName());
            categoryRepository.save(cat);
        }
        return cat;
    }

    @Override
    public Boolean delete(Long id) {
        Category cat = categoryRepository.findById(id).orElse(null);
        if (cat != null) {
            categoryRepository.delete(cat);
            return true;
        }
        return false;
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return null;
    }
}
