package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.SportLog;

import java.util.List;

@Repository
public interface SportLogDao extends JpaRepository<SportLog, Integer> {
    @Query(value = "SELECT * FROM sportlog WHERE phone_number = :phoneNumber ORDER BY sport_date DESC, sport_time DESC LIMIT 1", nativeQuery = true)
    SportLog findLatestSportByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    int countByPhoneNumberAndSportDateStartingWith(String phoneNumber, String todayStr);

    List<SportLog> findAllByPhoneNumber(String phoneNumber);
}
