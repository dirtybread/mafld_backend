package zjubiomedit.mafld_backend.entity;

import lombok.Data;

import javax.persistence.*;

//健康档案（基本信息）
@Data
@Entity
@Table(name = "healthfile")
public class HealthFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serialNo;
    private Integer patientId;
    private String phoneNumber;
//    基本信息
    private String name;
    private String sex;
    private Integer age;
    private String birthdate;
//    人口学
    private Double height;
    private Double weight;
    private Double bmi;

    private String bmiType;//体型类型
    private Double waist;
    private Integer cenOb;//腹部肥胖
    private Integer smoke;
    private Integer drink;
    private String diseaseHis;
    private String familyHis;
    private Integer medicineHis;
//    生化指标

    private  Double fpg;
    private  Double fins;
    private Double ir;

    private Double hba1c;
    private Integer sbp;
    private Integer dbp;
    private  Integer xy;//血压是否异常（偏高）

    private Double alt;
    private Double ast;
    private Double ggt;
    private Double tbil;
    private Integer ggn;//肝功能异常

    private Double tc;
    private Double ldl;
    private Double tg;
    private Integer xz;//血脂异常

    private Double ua;
    private Double cr;
    private Double bun;
    private Double uacr;
    private Integer sgn;//肾功能异常


    //影像检查
    private Integer egv;
    private Integer heart;
    private Integer ca;
    private Integer dr;
    private Integer dm;
    private Integer bfz;//并发症情况

    private Integer fib;
    private Integer fld;
    private Integer nash;


    private Integer riskLevel;

    private String updatetime;

}