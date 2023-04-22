package co.istad.thymeleaf.webapp.controller;


import co.istad.thymeleaf.webapp.model.Category;
import co.istad.thymeleaf.webapp.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoriesService categoriesService;

    List<Category> getAllCategory(){
        return  categoriesService.getCategories();
    }



}
