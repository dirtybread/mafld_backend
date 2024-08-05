package zjubiomedit.mafld_backend.entity;

import lombok.Data;

@Data
public class LoginRequest {
    private String phoneNumber;
    private String password;
}
