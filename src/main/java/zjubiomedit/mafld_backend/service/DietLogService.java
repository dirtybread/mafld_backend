package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.DietLogDao;
import zjubiomedit.mafld_backend.entity.DietLog;

import java.util.List;

@Service
public class DietLogService {
    @Autowired
    private DietLogDao dietLogDao;
    public  DietLog saveDietLog(DietLog dietLog){
        return  dietLogDao.save(dietLog);
    }

    public List<DietLog> getDietLogs(String phoneNumber, String date) {
        return dietLogDao.findDietLogsByPhoneNumberAndDateRange(phoneNumber, date);
    }

    public List<DietLog> getDietHistory(String phoneNumber) {
        return dietLogDao.findAllByPhoneNumber(phoneNumber);
    }
}
