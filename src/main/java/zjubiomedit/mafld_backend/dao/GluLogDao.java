package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.GluLog;

import java.util.List;

@Repository
public interface GluLogDao extends JpaRepository<GluLog, Integer> {
    @Query(value = "SELECT * FROM glulog WHERE phone_number = :phoneNumber ORDER BY glu_date DESC, glu_time DESC LIMIT 1", nativeQuery = true)
    GluLog findLatestGluByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    int countByPhoneNumberAndGluDateStartingWith(String phoneNumber, String todayStr);

    List<GluLog> findAllByPhoneNumber(String phoneNumber);
}
