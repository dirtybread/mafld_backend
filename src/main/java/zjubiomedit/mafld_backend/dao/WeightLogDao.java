package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.WeightLog;

import java.util.List;

@Repository
public interface WeightLogDao extends JpaRepository<WeightLog, Integer> {
    @Query(value = "SELECT * FROM weightlog WHERE phone_number = :phoneNumber ORDER BY weight_date DESC, weight_time DESC LIMIT 1", nativeQuery = true)
    WeightLog findLatestByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    int countByPhoneNumberAndWeightDateStartingWith(String phoneNumber, String datePrefix);

    List<WeightLog> findAllByPhoneNumber(String phoneNumber);
}
