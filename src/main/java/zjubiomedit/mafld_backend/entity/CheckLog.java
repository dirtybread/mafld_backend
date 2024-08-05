package zjubiomedit.mafld_backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "checklog")
public class CheckLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String phoneNumber;
    private String measureDatetime;
    private String uploadTime;
    private String imageUrls;  // 将图片URL存储为JSON字符串
    private String checkName;



}
