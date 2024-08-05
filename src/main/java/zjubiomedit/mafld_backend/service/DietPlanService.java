package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.DietPlanDao;
import zjubiomedit.mafld_backend.entity.DietPlan;

@Service
public class DietPlanService {

    @Autowired
    private DietPlanDao dietPlanDao;

    public DietPlan findLatestByPhoneNumber(String phoneNumber) {
        return dietPlanDao.findLatestByPhoneNumber(phoneNumber);
    }

    public DietPlan save(DietPlan dietPlan) {
        return dietPlanDao.save(dietPlan);
    }

    public DietPlan addDietPlan(DietPlan dietPlan) {
        return dietPlanDao.save(dietPlan);
    }
}