package zjubiomedit.mafld_backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dietlog")
public class DietLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phoneNumber;
    private String date;
    private String createDateTime;
    private String happenDateTime;
    private String dietType;
    private String dietContents; // JSON 字符串
    private String memo;
    private String photo; // JSON 字符串
}
