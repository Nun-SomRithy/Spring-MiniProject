package co.istad.thymeleaf.webapp.service.impl;

import co.istad.thymeleaf.webapp.model.Article;
import co.istad.thymeleaf.webapp.model.FileUpload;
import co.istad.thymeleaf.webapp.repository.PostRepository;
import co.istad.thymeleaf.webapp.service.ArticleService;
import co.istad.thymeleaf.webapp.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.spi.ServiceRegistry;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final FileUploadService fileUploadService;
    private final PostRepository postRepository;

    @Override
    public List<Article> findAll() {
        // TODO:
        // Your logic
        return postRepository.getArticles();
    }

    @Override
    public List<Article> findAllPostByUserId(Integer id) {
        return postRepository.findAllPostByUserId(id);
    }




    @Override
    public boolean save(Article article, MultipartFile file) {
        FileUpload fileUpload = fileUploadService.uploadSingle(file);
        if (fileUpload.isSucceed()) {
//          article.setUuid(UUID.randomUUID().toString());
            article.setThumbnail("/files/"+fileUpload.fileName());
            System.out.println(article);
            postRepository.getArticles().add(0, article);
        }
        return true;
    }
}
