package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.FoodUnit;

import java.util.List;

@Repository
public interface FoodUnitDao extends JpaRepository<FoodUnit, Integer> {

    List<FoodUnit> findByFoodSerialNo(Integer foodSerialNo);
}
