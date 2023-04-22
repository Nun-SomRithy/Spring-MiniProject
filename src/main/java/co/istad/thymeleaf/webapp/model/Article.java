package co.istad.thymeleaf.webapp.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private String uuid;

//    @NotBlank(message = "Title is required..!")
    private String title;

    private String thumbnail;

    private String description;

//    @NotBlank(message = "Author is required..!")
    private User  author;
    private List<Category> category;
}
