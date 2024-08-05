package zjubiomedit.mafld_backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "food_measure_unit")
public class FoodUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serialNo;
    private Long foodSerialNo;
    private Float numberPart;

    private String unitPart;

    private String unitNamePart;

    private String levelPart;

    private Float allupPart;

    private Float ediblePart;

    private Byte flag;
}
