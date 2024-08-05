package zjubiomedit.mafld_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjubiomedit.mafld_backend.dao.UserDao;
import zjubiomedit.mafld_backend.entity.User;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    public boolean search(String phoneNumber) {
        User user = userDao.findByPhoneNumber(phoneNumber);
        if (user!=null) return true;
        else return false;
    }

    public void save(String phoneNumber) {
        User newUser = new User();
        newUser.setPhoneNumber(phoneNumber);
        newUser.setRole(0);//默认身份为患者（0）
        newUser.setRegisterTime(new Date()); // 设置注册时间
        userDao.save(newUser);
    }
    public User update(User user){
        User existingUser = userDao.findByPhoneNumber(user.getPhoneNumber());
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setSex(user.getSex());
        User savedUser = userDao.save(existingUser);
        return savedUser;
    }

    public User findByPhoneNumber(String phoneNumber) {
        return userDao.findByPhoneNumber(phoneNumber);
    }

    public List<User> getPatients() {
        return userDao.findByRole(0);
    }
}
