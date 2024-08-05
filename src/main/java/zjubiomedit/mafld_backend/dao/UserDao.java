package zjubiomedit.mafld_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zjubiomedit.mafld_backend.entity.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
    // 根据phoneNumber查找用户
    User findByPhoneNumber(String phoneNumber);

    List<User> findByRole(int role);
}