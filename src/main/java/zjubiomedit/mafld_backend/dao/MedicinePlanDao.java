package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.MedicinePlan;

import java.util.List;

@Repository
public interface MedicinePlanDao extends JpaRepository<MedicinePlan,Integer> {
    List<MedicinePlan> findByPhoneNumber(String phoneNumber);

}
