package co.istad.thymeleaf.webapp.controller;

import co.istad.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf.webapp.model.Category;
import co.istad.thymeleaf.webapp.model.User;
import co.istad.thymeleaf.webapp.repository.CategoryRepository;
import co.istad.thymeleaf.webapp.repository.UserRepository;
import co.istad.thymeleaf.webapp.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @GetMapping
    String viewArticle(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "pages/article/article";
    }

    @GetMapping("/new")
    String viewArticleNew(Article article, Model model) {
        List<Category> categories= categoryRepository.getAllCategory();
        List<User> users = userRepository.getListUser();
        model.addAttribute("article", article);
        model.addAttribute("category",categories);
        model.addAttribute("user", users );
        return "pages/article/article-new";
    }

    public List<Article> findAllPostByUserId(Integer id){
        return articleService.findAllPostByUserId(id);
    }


    @PostMapping("/new")
    String doSaveArticle(@ModelAttribute @Valid Article article,
                         BindingResult result,
                         @RequestParam("thumbnailFile") MultipartFile file,
                         Model model) {

                article.setAuthor(userRepository.getListUser().get(1));
                article.setUuid(UUID.randomUUID().toString());
                article.setCategory(List.of(categoryRepository.getAllCategory().get(1)));
//                System.out.println(article);

//        if (result.hasErrors()) {
//            List<Category> categories= categoryRepository.getAllCategory();
//            List<User> users = userRepository.getListUser();
//            model.addAttribute("article", article);
//            model.addAttribute("category",categories);
//            model.addAttribute("user", users );
//            return "pages/article/article-new";
//        }

        boolean isSucceed = articleService.save(article, file);

//        if (isSucceed) {
//            return "redirect:/article";
//        }

        return "redirect:/";
    }



}