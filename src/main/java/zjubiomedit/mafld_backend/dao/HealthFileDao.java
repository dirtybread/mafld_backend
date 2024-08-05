package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.HealthFile;

@Repository
public interface HealthFileDao extends JpaRepository<HealthFile, Integer> {
    @Query(value = "SELECT * FROM healthfile WHERE phone_number = :phoneNumber ORDER BY STR_TO_DATE(updatetime, '%Y-%m-%d %H:%i:%s') DESC LIMIT 1", nativeQuery = true)
    HealthFile findLatestFileByPhoneNumber(@Param("phoneNumber") String phoneNumber);
    @Query("SELECT MAX(h.patientId) FROM HealthFile h")
    Integer findMaxPatientId();
}