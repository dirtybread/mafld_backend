package zjubiomedit.mafld_backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zjubiomedit.mafld_backend.entity.LoginRequest;
import zjubiomedit.mafld_backend.entity.LoginResponse;

@RestController
public class LoginController {
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = new LoginResponse();

        // 这里应该添加逻辑来验证用户的手机号和密码
        System.out.println(loginRequest);
        // 假设验证逻辑通过
        boolean isValidUser = true;

        if (isValidUser) {
            response.setSuccess(true);
            response.setToken(loginRequest.getPhoneNumber());
            response.setMessage("登录成功");
        } else {
            response.setSuccess(false);
            response.setMessage("手机号或密码错误");
        }

        return response;
    }


}
