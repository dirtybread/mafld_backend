package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.FoodDao;
import zjubiomedit.mafld_backend.dao.FoodUnitDao;
import zjubiomedit.mafld_backend.entity.Food;
import zjubiomedit.mafld_backend.entity.FoodUnit;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodDao foodDao;
    @Autowired
    private FoodUnitDao foodUnitDao;
    public List<Food> findByAlias(String foodName) {
        return foodDao.findByAliasLike("%" + foodName.trim() + "%");
    }

    public List<FoodUnit> findBySerialNo(Integer foodSerialNo){
        return foodUnitDao.findByFoodSerialNo(foodSerialNo);
    }

    public List<Food> findByName(String name) {
        return foodDao.findByNameLike("%" + name.trim() + "%");
    }
}
