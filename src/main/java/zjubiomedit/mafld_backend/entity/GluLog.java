package zjubiomedit.mafld_backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "glulog")
public class GluLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String phoneNumber;
    private Double glu;
    private String gluDate;
    private String gluTime;
    private String gluTimepoint;
    private String source;
}
