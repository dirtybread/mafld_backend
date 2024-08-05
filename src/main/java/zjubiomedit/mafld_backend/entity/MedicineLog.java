package zjubiomedit.mafld_backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "medicinelog")
public class MedicineLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String phoneNumber;
    private String medicineDate;
    private String medicineTime;
    private String medicineName;
    private String medicineAmount;
    private  String memo;
}
