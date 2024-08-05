package zjubiomedit.mafld_backend.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "weightlog")
public class WeightLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String phoneNumber;
    private Double weight;
    private String weightDate;
    private String weightTime;
    private String source;
}
