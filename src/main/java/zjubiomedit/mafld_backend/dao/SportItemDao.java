package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import zjubiomedit.mafld_backend.entity.SportItem;

import java.util.List;

public interface SportItemDao extends JpaRepository<SportItem, Integer> {
    List<SportItem> findByType(String type);
}
