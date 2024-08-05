package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.SportPlanDao;
import zjubiomedit.mafld_backend.entity.SportPlan;

@Service
public class SportPlanService {

    @Autowired
    private SportPlanDao sportPlanDao;

    public SportPlan findLatestByPhoneNumber(String phoneNumber) {
        return sportPlanDao.findLatestByPhoneNumber(phoneNumber);
    }

    public SportPlan save(SportPlan sportPlan) {
        return sportPlanDao.save(sportPlan);
    }

    public SportPlan addSportPlan(SportPlan sportPlan) {
        return sportPlanDao.save(sportPlan);
    }
}