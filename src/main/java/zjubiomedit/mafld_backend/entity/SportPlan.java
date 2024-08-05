package zjubiomedit.mafld_backend.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="sportplan")
public class SportPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String phoneNumber;
    private String intensity;
    private Double time;
    private String startDate;
    private String startTime;
}