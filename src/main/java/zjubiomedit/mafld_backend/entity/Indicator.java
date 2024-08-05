package zjubiomedit.mafld_backend.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Indicator {
    private float weight;
    private float bloodSugar;
    private float waist;
    private Date time;
}
