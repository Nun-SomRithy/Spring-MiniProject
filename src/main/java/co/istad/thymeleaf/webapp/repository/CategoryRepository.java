package co.istad.thymeleaf.webapp.repository;

import co.istad.thymeleaf.webapp.model.Category;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    private  List<Category> categories;

    @PostConstruct
    void init(){
        categories=new ArrayList<>(
                List.of(
                        new Category(1,"Education"),
                        new Category(2,"Science"),
                        new Category(3,"Sport")
                )
        );
    }

    public List<Category> getAllCategory(){

        return categories;
    }


}
