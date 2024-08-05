package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.SportPlan;

@Repository
public interface SportPlanDao extends JpaRepository<SportPlan, Integer> {
    @Query(value = "SELECT * FROM sportplan WHERE phone_number = :phoneNumber ORDER BY start_date DESC, start_time DESC LIMIT 1", nativeQuery = true)
    SportPlan findLatestByPhoneNumber(String phoneNumber);
}
