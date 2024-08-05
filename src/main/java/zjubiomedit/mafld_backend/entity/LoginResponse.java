package zjubiomedit.mafld_backend.entity;

import lombok.Data;

@Data
public class LoginResponse {
    private boolean success;
    private String token;
    private String message;
}
