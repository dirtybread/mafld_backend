package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.HealthFileDao;
import zjubiomedit.mafld_backend.entity.HealthFile;

@Service
public class HealthFileService {

    @Autowired
    private HealthFileDao healthFileDao;

    public HealthFile save(HealthFile healthFile) {
        return healthFileDao.save(healthFile);
    }
    public HealthFile getLatestRecords(String phoneNumber) {
        return  healthFileDao.findLatestFileByPhoneNumber(phoneNumber);
    }

    public HealthFile create(String phoneNumber) {
        HealthFile newPatient = new HealthFile();
//        newPatient.setUpdatetime(new Date());

        newPatient.setPhoneNumber(phoneNumber);

        // 生成新的patientId
        Integer maxPatientId = healthFileDao.findMaxPatientId();
        if (maxPatientId == null) {
            maxPatientId = 0; // 如果数据库为空，则从1开始分配
        }
        newPatient.setPatientId(maxPatientId + 1);
        return  healthFileDao.save(newPatient);
    }
}