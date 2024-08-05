package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.DietLog;

import java.util.List;

@Repository
public interface DietLogDao extends JpaRepository<DietLog, Integer> {
//    @Query(value = "SELECT * FROM dietlog WHERE phone_number = :phoneNumber AND happen_date_time BETWEEN :startDate AND :endDate", nativeQuery = true)
//    List<DietLog> findDietLogsByPhoneNumberAndDateRange(@Param("phoneNumber") String phoneNumber, @Param("startDate") String startDate, @Param("endDate") String endDate);
    @Query(value = "SELECT * FROM dietlog WHERE phone_number = :phoneNumber AND date= :date", nativeQuery = true)
    List<DietLog> findDietLogsByPhoneNumberAndDateRange(@Param("phoneNumber") String phoneNumber, @Param("date") String date);

    List<DietLog> findAllByPhoneNumber(String phoneNumber);
}
