package zjubiomedit.mafld_backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zjubiomedit.mafld_backend.entity.RegisterRequest;
import zjubiomedit.mafld_backend.entity.RegisterResponse;

@RestController
public class RegisterController {
    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse response=new RegisterResponse();
        System.out.println(registerRequest);
        // 模拟用户注册成功
        response.setSuccess(true);
        response.setToken("generated-token");
        response.setMessage("用户注册成功");
        return  response;
    }
}
