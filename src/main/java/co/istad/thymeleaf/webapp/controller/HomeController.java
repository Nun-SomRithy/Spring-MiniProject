package co.istad.thymeleaf.webapp.controller;

import co.istad.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf.webapp.model.Category;
import co.istad.thymeleaf.webapp.repository.CategoryRepository;
import co.istad.thymeleaf.webapp.repository.PostRepository;
import co.istad.thymeleaf.webapp.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ArticleService articleService;
    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;
    @GetMapping("/")
    String viewHome(Model model) {
        List<Article> articles = postRepository.getArticles();
        List<Category> categories= categoryRepository.getAllCategory();
        System.out.println(articles.get(0).getThumbnail());
        model.addAttribute("articles", articles);
        System.out.println(articles);
        model.addAttribute("categories",categories);
        return "pages/index";
    }

}
