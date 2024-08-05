package zjubiomedit.mafld_backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "healthlog")
public class HealthLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String phoneNumber;
    private String quicklogTime;
    private Double  weight;
    private String weightTime;
    private Double  waist;
    private Double  water;
    private Double  sleep;
    private Double  sys;
    private Double  dia;
    private String bpTime;
    private Double  glu;
    private String gluTime;
    private String gluTimepoint;

}

