package zjubiomedit.mafld_backend.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zjubiomedit.mafld_backend.config.AppInfoConfig;
import zjubiomedit.mafld_backend.entity.HealthFile;
import zjubiomedit.mafld_backend.entity.User;
import zjubiomedit.mafld_backend.service.HealthFileService;
import zjubiomedit.mafld_backend.service.UserService;
import zjubiomedit.mafld_backend.utils.UtilClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AppInfoConfig appInfoConfig;
    @Autowired
    private UserService userService;
    @Autowired
    private HealthFileService healthFileService;

    @GetMapping("/getphoneNumber")
    public ResponseEntity<Map<String, Object>> getPhoneNumber(@RequestParam String code) {
        JSONObject res = UtilClass.getPhoneNumber(code, appInfoConfig.getAppId(), appInfoConfig.getAppSecret());
        Map<String, Object> response = new HashMap<>();

        if (res != null && res.getInteger("errcode") == 0) {
            JSONObject phoneInfo = res.getJSONObject("phone_info");
            //phoneInfo 手机号
            if (phoneInfo != null) {
                String phoneNumber = phoneInfo.getString("phoneNumber");

                // 检查用户是否已存在：查询用户信息user数据库
                boolean ifExist = userService.search(phoneNumber);
                //备注字段isRegistered为是否已注册
                response.put("isRegistered", ifExist);

                //如果用户不存在，则需要保存到user中，默认身份为patient（0）
                if (!ifExist) {
                    userService.save(phoneNumber);
                    healthFileService.create(phoneNumber);
                }
                //此时不管存在与否都已经可以在用户数据库中找到患者的注册信息
                //通过身份（role），查询对应的信息，分为患者和医生两种，在不同的库中查询
                User user = userService.findByPhoneNumber(phoneNumber);
                //将用户注册信息存储到返回变量中
                response.put("userInfo", user);

                //如果是患者身份 ？这个有必要嘛
                if (user.getRole()==0){
                    HealthFile healthFile=healthFileService.getLatestRecords(phoneNumber);
                    response.put("healthFile", healthFile);
                }
                //如果是医生身份，只有userInfo就可以了
                else{

                }


                return ResponseEntity.ok(response);
            }
        }

        response.put("error", "获取手机号码失败");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
//    获取所有患者的注册信息
    @GetMapping("/getpatients")
    public ResponseEntity<List<User>> getPatientsFiles() {
        //获取的患者列表一定是已经注册完成的
        //若只有注册信息而无健康档案信息，则将注册信息返回至前端
        List<User> patientList = userService.getPatients();
//        List<HealthFile> result = new ArrayList<>();
//        for (User patient : patientList){
//            String phoneNumber = patient.getPhoneNumber();
//            HealthFile healthFile = new HealthFile();
//            if (healthFileService.getLatestRecords(phoneNumber) !=null){
//                healthFile =healthFileService.getLatestRecords(phoneNumber);
//                result.add(healthFile);
//            }
//            else{
//                //创建临时healthFile
//                healthFile.setPhoneNumber(phoneNumber);
//                healthFile.setName(patient.getName());
//                healthFile.setAge(patient.getAge());
//                healthFile.setSex(patient.getSex());
//                result.add(healthFile);
//            }
//        }
//        return ResponseEntity.ok(result);
        return ResponseEntity.ok(patientList);
    }
    @GetMapping("/searchPhoneNumber")
    public ResponseEntity<User> searchUser(@RequestParam String phoneNumber){
//        System.out.println(phoneNumber);
        return ResponseEntity.ok(userService.findByPhoneNumber(phoneNumber));
    }
    @PostMapping("/updateInfo")
    public ResponseEntity<User> updateUserInfo(@RequestBody User user) {
        System.out.println(user);
        return ResponseEntity.ok(userService.update(user));
    }

}
