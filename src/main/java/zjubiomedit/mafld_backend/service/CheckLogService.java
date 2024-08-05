package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.CheckLogDao;
import zjubiomedit.mafld_backend.entity.CheckLog;

import java.util.List;

@Service
public class CheckLogService {
    @Autowired
    private CheckLogDao checkLogDao;
    public CheckLog saveCheckLog(CheckLog checkLog) {
        return checkLogDao.save(checkLog);
    }

    public List<CheckLog> getCheckLogsByPhoneNumber(String phoneNumber) {
        return checkLogDao.findByPhoneNumberOrderByUploadTimeDesc(phoneNumber);
    }
}
