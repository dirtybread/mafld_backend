package zjubiomedit.mafld_backend.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sportitem")
public class SportItem {
    @Id
    @GeneratedValue
    private int id;
    private String type;
    private String name;
    private String intensity;
    private Double  met;

}
