package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.WeightPlanDao;
import zjubiomedit.mafld_backend.entity.WeightPlan;

@Service
public class WeightPlanService {

    @Autowired
    private WeightPlanDao weightPlanDao;

    public WeightPlan findLatestByPhoneNumber(String phoneNumber) {
        return weightPlanDao.findLatestByPhoneNumber(phoneNumber);
    }

    public WeightPlan save(WeightPlan weightPlan) {
        return weightPlanDao.save(weightPlan);
    }

    public WeightPlan addWeightPlan(WeightPlan weightPlan) {
        return weightPlanDao.save(weightPlan);
    }
}