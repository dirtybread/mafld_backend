package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.Food;

import java.util.List;

@Repository
public interface FoodDao extends JpaRepository<Food, Integer> {
    List<Food> findByAliasLike(String s);

    List<Food> findByNameLike(String s);
}
