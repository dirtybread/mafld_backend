package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.Article;

@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {

}
