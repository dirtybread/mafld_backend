package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.GluLogDao;
import zjubiomedit.mafld_backend.entity.GluLog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class GluLogService {
    @Autowired
    private GluLogDao gluLogDao;

    public GluLog addGluLog(GluLog gluLog) {
        return gluLogDao.save(gluLog);
    }

    public GluLog findLatestByPhoneNumber(String phoneNumber) {
        return gluLogDao.findLatestGluByPhoneNumber(phoneNumber);
    }

    public int countTodayGluLogs(String phoneNumber) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayStr = today.format(formatter);
        return gluLogDao.countByPhoneNumberAndGluDateStartingWith(phoneNumber, todayStr);
    }

    public GluLog save(GluLog gluLog) {
        return gluLogDao.save(gluLog);
    }

    public List<GluLog> getGluHistory(String phoneNumber) {
        return gluLogDao.findAllByPhoneNumber(phoneNumber);
    }
}
