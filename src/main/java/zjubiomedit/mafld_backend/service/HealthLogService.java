package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.HealthLogDao;
import zjubiomedit.mafld_backend.entity.HealthLog;

@Service
public class HealthLogService {

    @Autowired
    private HealthLogDao healthLogDao;

    public HealthLog findLatestBloodPressureByPhoneNumber(String phoneNumber) {
        return healthLogDao.findLatestBloodPressureByPhoneNumber(phoneNumber);
    }

    public HealthLog findLatestWaistByPhoneNumber(String phoneNumber) {
        return healthLogDao.findLatestWaistByPhoneNumber(phoneNumber);
    }

    public HealthLog save(HealthLog healthLog) {
        return healthLogDao.save(healthLog);
    }
}
