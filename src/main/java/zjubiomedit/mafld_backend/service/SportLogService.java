package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.SportLogDao;
import zjubiomedit.mafld_backend.entity.SportLog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SportLogService {

    @Autowired
    private SportLogDao sportLogDao;

    public SportLog addSportLog(SportLog sportLog) {
        return sportLogDao.save(sportLog);
    }

    public SportLog findLatestByPhoneNumber(String phoneNumber) {
        return sportLogDao.findLatestSportByPhoneNumber(phoneNumber);
    }

    public int countTodaySportLogs(String phoneNumber) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayStr = today.format(formatter);
        return sportLogDao.countByPhoneNumberAndSportDateStartingWith(phoneNumber, todayStr);
    }

    public List<SportLog> getSportHistory(String phoneNumber) {
        return sportLogDao.findAllByPhoneNumber(phoneNumber);
    }
}