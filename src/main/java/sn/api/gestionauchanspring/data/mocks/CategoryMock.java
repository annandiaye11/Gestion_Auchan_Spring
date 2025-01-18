package sn.api.gestionauchanspring.data.mocks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.api.gestionauchanspring.data.entities.Category;
import sn.api.gestionauchanspring.data.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMock implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public CategoryMock(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.setCode("Code" + i);
            category.setName("Name" + i);
            categories.add(category);
        }
    categoryRepository.saveAllAndFlush(categories);
    }
}
