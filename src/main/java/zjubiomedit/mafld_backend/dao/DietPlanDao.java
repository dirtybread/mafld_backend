package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zjubiomedit.mafld_backend.entity.DietPlan;

public interface DietPlanDao extends JpaRepository<DietPlan, Integer> {
    @Query(value = "SELECT * FROM dietplan WHERE phone_number = :phoneNumber ORDER BY start_date DESC, start_time DESC LIMIT 1", nativeQuery = true)
    DietPlan findLatestByPhoneNumber(String phoneNumber);
}
