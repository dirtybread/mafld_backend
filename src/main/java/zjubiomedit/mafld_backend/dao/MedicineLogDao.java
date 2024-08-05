package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import zjubiomedit.mafld_backend.entity.MedicineLog;

import java.util.List;

public interface MedicineLogDao extends JpaRepository<MedicineLog,Integer> {
    int countByPhoneNumberAndMedicineDateStartingWith(String phoneNumber, String todayStr);
    @Query(value = "SELECT * FROM medicinelog WHERE phone_number = :phoneNumber ORDER BY medicine_date DESC, medicine_time DESC LIMIT 1", nativeQuery = true)
    MedicineLog findLatestMedicineByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    List<MedicineLog> findAllByPhoneNumber(String phoneNumber);
}
