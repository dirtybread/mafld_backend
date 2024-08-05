package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.MedicineLogDao;
import zjubiomedit.mafld_backend.entity.MedicineLog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MedicineLogService {
    @Autowired
    private MedicineLogDao medicineLogDao;
    public MedicineLog addMedicineLog(MedicineLog medicineLog) {
        return medicineLogDao.save(medicineLog);
    }

    public int countTodayMedicineLogs(String phoneNumber) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayStr = today.format(formatter);
        return medicineLogDao.countByPhoneNumberAndMedicineDateStartingWith(phoneNumber, todayStr);
    }
    public MedicineLog findLatestByPhoneNumber(String phoneNumber) {
        return medicineLogDao.findLatestMedicineByPhoneNumber(phoneNumber);
    }

    public List<MedicineLog> getMedicineHistory(String phoneNumber) {
        return medicineLogDao.findAllByPhoneNumber(phoneNumber);
    }
}
