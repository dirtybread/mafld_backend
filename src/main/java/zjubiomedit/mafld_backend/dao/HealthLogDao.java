package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import zjubiomedit.mafld_backend.entity.HealthLog;

public interface HealthLogDao extends JpaRepository<HealthLog, Integer> {
    @Query(value = "SELECT * FROM healthlog WHERE phone_number = :phoneNumber ORDER BY STR_TO_DATE(weight_time, '%Y-%m-%d %H:%i:%s') DESC LIMIT 1", nativeQuery = true)
    HealthLog findLatestWeightByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Query(value = "SELECT * FROM healthlog WHERE phone_number = :phoneNumber ORDER BY STR_TO_DATE(glu_time, '%Y-%m-%d %H:%i:%s') DESC LIMIT 1", nativeQuery = true)
    HealthLog findLatestGluByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Query(value = "SELECT * FROM healthlog WHERE phone_number = :phoneNumber AND sys IS NOT NULL AND dia IS NOT NULL ORDER BY STR_TO_DATE(quicklog_time, '%Y-%m-%d %H:%i:%s') DESC LIMIT 1", nativeQuery = true)
    HealthLog findLatestBloodPressureByPhoneNumber(String phoneNumber);

    @Query(value = "SELECT * FROM healthlog WHERE phone_number = :phoneNumber AND waist IS NOT NULL ORDER BY STR_TO_DATE(quicklog_time, '%Y-%m-%d %H:%i:%s') DESC LIMIT 1", nativeQuery = true)
    HealthLog findLatestWaistByPhoneNumber(String phoneNumber);
}

