package co.istad.thymeleaf.webapp.service;

import co.istad.thymeleaf.webapp.model.Category;

import java.util.List;

public interface CategoriesService {
    List<Category> getCategories();

    List<Category> getByCategories(List<Integer> categories_id);

}
