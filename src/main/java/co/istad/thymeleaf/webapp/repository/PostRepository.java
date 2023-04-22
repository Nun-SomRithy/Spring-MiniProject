package co.istad.thymeleaf.webapp.repository;

import co.istad.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf.webapp.model.Category;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Getter
@RequiredArgsConstructor
public class PostRepository {

    private List<Article> articles;

    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;
    @PostConstruct
    void init(){

        Random random =new Random();
        List<Category> categories=categoryRepository.getAllCategory();

        articles=new ArrayList<>(){{

            add(new Article(
                    UUID.randomUUID().toString(),
                    "This is new Article",
                    "https://images.pexels.com/photos/1323206/pexels-photo-1323206.jpeg?cs=srgb&dl=pexels-mixu-1323206.jpg&fm=jpg",
                    "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour,",
                    userRepository.getListUser().get(0),
                    List.of(categories.get(random.nextInt(categories.size())))
                    ));
            add(new Article(
                    UUID.randomUUID().toString(),
                    "How to do not sleep",
                    "https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
                    "Meditate every morning and every evening for 15-30 minutes. Use your mantra in Your First Meditation above. It is best to meditate before you eat.  ",
                    userRepository.getListUser().get(1),
                    List.of(categories.get(random.nextInt(categories.size())))
            ));
            add(new Article(
                    UUID.randomUUID().toString(),
                    "How to Drive Car",
                    "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80   ",
                    "Your First Meditation\n" +
                            "To begin meditating, find a place where you can sit comfortably and quietly. Then close your eyes and do nothing for a minute or so.",
                    userRepository.getListUser().get(2),
                    List.of(categories.get(random.nextInt(categories.size())))
            )); add(new Article(
                    UUID.randomUUID().toString(),
                    "How to Drink Orange",
                    "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80   ",
                    "Your First Meditation\n" +
                            "To begin meditating, find a place where you can sit comfortably and quietly. Then close your eyes and do nothing for a minute or so.",
                    userRepository.getListUser().get(2),
                    List.of(categories.get(random.nextInt(categories.size())))
            ));
        }};

    }
    public List<Article> findAllPostByUserId(Integer id){

        return articles.stream().
                filter(article -> article.getAuthor().getId().equals(id)).
                collect(Collectors.toList());
    }

}
