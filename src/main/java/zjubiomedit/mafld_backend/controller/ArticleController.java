package zjubiomedit.mafld_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zjubiomedit.mafld_backend.entity.Article;
import zjubiomedit.mafld_backend.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/getAll")
    public List<Article> getArticle(){
        return articleService.findAll();
    }
}
