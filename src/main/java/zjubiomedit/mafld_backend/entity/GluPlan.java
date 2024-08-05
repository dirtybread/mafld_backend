package zjubiomedit.mafld_backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="gluplan")
public class GluPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String phoneNumber;
    private String gluType;
    private String startDate;
    private String startTime;

}