package zjubiomedit.mafld_backend.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="weightplan")
public class WeightPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String phoneNumber;
    private Double initWeight;
    private Double weightGoal;
    private Double period;
    private Double averageWeight;
    private String startDate;
    private String startTime;

}