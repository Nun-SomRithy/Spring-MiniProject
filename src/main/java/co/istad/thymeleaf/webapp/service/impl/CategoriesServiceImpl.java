package co.istad.thymeleaf.webapp.service.impl;

import co.istad.thymeleaf.webapp.model.Category;
import co.istad.thymeleaf.webapp.repository.CategoryRepository;
import co.istad.thymeleaf.webapp.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {


    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {

        return categoryRepository.getAllCategory();
    }

    @Override
    public List<Category> getByCategories(List<Integer> categories_id){
        List<Category> categories = this.getCategories().stream().filter(category -> {
            return categories_id.contains(category.getId());
        }).toList();
        return categories;
    };



}
