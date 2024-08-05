package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.ArticleDao;
import zjubiomedit.mafld_backend.entity.Article;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public List<Article> findAll() {
        return articleDao.findAll();
    }
}
