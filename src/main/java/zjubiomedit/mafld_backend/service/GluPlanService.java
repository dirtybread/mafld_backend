package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.GluPlanDao;
import zjubiomedit.mafld_backend.entity.GluPlan;

@Service
public class GluPlanService {

    @Autowired
    private GluPlanDao gluPlanDao;

    public GluPlan findLatestByPhoneNumber(String phoneNumber) {
        return gluPlanDao.findLatestByPhoneNumber(phoneNumber);
    }

    public GluPlan save(GluPlan gluPlan) {
        return gluPlanDao.save(gluPlan);
    }

    public GluPlan addGluPlan(GluPlan gluPlan) {
        return gluPlanDao.save(gluPlan);
    }
}
