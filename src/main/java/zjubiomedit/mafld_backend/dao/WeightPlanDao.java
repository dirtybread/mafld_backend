package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.WeightPlan;

@Repository
public interface WeightPlanDao extends JpaRepository<WeightPlan, Integer> {
    @Query(value = "SELECT * FROM weightplan WHERE phone_number = :phoneNumber ORDER BY start_date DESC, start_time DESC LIMIT 1", nativeQuery = true)
    WeightPlan findLatestByPhoneNumber(String phoneNumber);
}
