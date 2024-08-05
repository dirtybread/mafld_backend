package zjubiomedit.mafld_backend.entity;

import lombok.Data;
@Data
public class RegisterResponse {
    private boolean success;
    private String token;
    private String message;
}
