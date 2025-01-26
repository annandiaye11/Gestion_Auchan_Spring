package sn.api.gestionauchanspring.data.mocks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sn.api.gestionauchanspring.data.entities.Article;
import sn.api.gestionauchanspring.data.entities.Category;
import sn.api.gestionauchanspring.services.ArticleService;
import sn.api.gestionauchanspring.services.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Order(2)
@Component
public class ArticleMock implements CommandLineRunner {
    private ArticleService articleService;
    private CategoryService categoryService;

    public ArticleMock(CategoryService categoryService, ArticleService articleService) {
        this.categoryService = categoryService;
        this.articleService = articleService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Category> categories = categoryService.getAllCategories();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setName("Article " + i);
            article.setQteStock(random.nextInt(100));
            article.setCategory(categories.get(random.nextInt(categories.size())));
            articleService.create(article);
        }
    }
}
