package zjubiomedit.mafld_backend.entity;

import lombok.Data;

@Data
public class RegisterRequest {
    private String phoneNumber;
    private String password;
}
