package zjubiomedit.mafld_backend.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sportlog")
public class SportLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String phoneNumber;
    private String sportDate;
    private String sportTime;
    private String type;
    private String item;
    private String intensity;
    private Double  durationTime;
    private  Double  energy;
    private  String memo;
}
