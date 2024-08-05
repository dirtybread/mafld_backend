package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.MedicinePlanDao;
import zjubiomedit.mafld_backend.entity.MedicinePlan;

import java.util.List;

@Service
public class MedicinePlanService {
    @Autowired
    private MedicinePlanDao medicinePlanDao;
    public List<MedicinePlan> findByPhoneNumber(String phoneNumber) {
        return medicinePlanDao.findByPhoneNumber(phoneNumber);
    }


}

