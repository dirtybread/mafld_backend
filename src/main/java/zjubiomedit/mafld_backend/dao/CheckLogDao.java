package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.CheckLog;

import java.util.List;

@Repository
public interface CheckLogDao extends JpaRepository<CheckLog, Integer> {
    List<CheckLog> findByPhoneNumberOrderByUploadTimeDesc(String phoneNumber);
}
