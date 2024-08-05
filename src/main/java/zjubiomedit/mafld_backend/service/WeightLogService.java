package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.WeightLogDao;
import zjubiomedit.mafld_backend.entity.WeightLog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class WeightLogService {

    @Autowired
    private WeightLogDao weightLogDao;

    public WeightLog save(WeightLog weightLog) {
        return weightLogDao.save(weightLog);
    }

    public WeightLog findLatestByPhoneNumber(String phoneNumber) {
        return weightLogDao.findLatestByPhoneNumber(phoneNumber);
    }

    public int countTodayWeightLogs(String phoneNumber) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayStr = today.format(formatter);
        return weightLogDao.countByPhoneNumberAndWeightDateStartingWith(phoneNumber, todayStr);
    }

    public List<WeightLog> getWeightHistory(String phoneNumber) {
        return weightLogDao.findAllByPhoneNumber(phoneNumber);
    }
}
