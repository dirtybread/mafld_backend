package zjubiomedit.mafld_backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tlcheeduknowledge")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String title;
    private String content;
    private String imageUrl;
    private Integer loveNum;
    private Integer comments;
    private Integer type;
    private Integer dayindex;
    private Integer readAlreadyNum;

}

