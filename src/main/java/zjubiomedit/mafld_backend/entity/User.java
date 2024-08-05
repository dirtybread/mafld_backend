package zjubiomedit.mafld_backend.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serialNo;
    private String phoneNumber;
//    private Integer patientId;
    private Integer role;
    private String name;
    private String sex;
    private Integer age;

    private String birthDate;

    private Date registerTime;
}
