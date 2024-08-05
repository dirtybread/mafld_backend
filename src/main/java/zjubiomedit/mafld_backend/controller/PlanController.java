package zjubiomedit.mafld_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zjubiomedit.mafld_backend.entity.*;
import zjubiomedit.mafld_backend.service.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private WeightPlanService weightPlanService;
    @GetMapping("/getweightPlan")
    public ResponseEntity<WeightPlan> getWeightPlan(@RequestParam String phoneNumber) {
        WeightPlan weightPlan = weightPlanService.findLatestByPhoneNumber(phoneNumber);
        if (weightPlan != null) {
            return ResponseEntity.ok(weightPlan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/submitweightPlan")
    public ResponseEntity<WeightPlan> addWeightPlan(@RequestBody WeightPlan weightPlan) {
        System.out.println(weightPlan);
        WeightPlan savedWeightPlan = weightPlanService.addWeightPlan(weightPlan);
        return new ResponseEntity<>(savedWeightPlan, HttpStatus.CREATED);
    }

//    血糖
    @Autowired
    private GluPlanService gluPlanService;
    @GetMapping("/getgluPlan")
    public ResponseEntity<GluPlan> getGluPlan(@RequestParam String phoneNumber) {
        GluPlan gluPlan = gluPlanService.findLatestByPhoneNumber(phoneNumber);
        if (gluPlan != null) {
            return ResponseEntity.ok(gluPlan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/submitgluPlan")
    public ResponseEntity<GluPlan> addGluPlan(@RequestBody GluPlan gluPlan) {
        System.out.println(gluPlan);
        GluPlan savedGluPlan = gluPlanService.addGluPlan(gluPlan);
        return new ResponseEntity<>(savedGluPlan, HttpStatus.CREATED);
    }

    @Autowired
    private SportPlanService sportPlanService ;
    @GetMapping("/getsportPlan")
    public ResponseEntity<SportPlan> getSportPlan(@RequestParam String phoneNumber) {
//        System.out.println(phoneNumber);
        SportPlan sportPlan = sportPlanService.findLatestByPhoneNumber(phoneNumber);
        if (sportPlan != null) {
            return ResponseEntity.ok(sportPlan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/submitsportPlan")
    public ResponseEntity<SportPlan> addSportPlan(@RequestBody SportPlan sportPlan) {
        System.out.println(sportPlan);
        SportPlan savedSportPlan = sportPlanService.addSportPlan(sportPlan);
        return new ResponseEntity<>(savedSportPlan, HttpStatus.CREATED);
    }

    @Autowired
    private DietPlanService dietPlanService ;
    @GetMapping("/getdietPlan")
    public ResponseEntity<DietPlan> getDietPlan(@RequestParam String phoneNumber) {
        DietPlan dietPlan = dietPlanService.findLatestByPhoneNumber(phoneNumber);
        if (dietPlan != null) {
            return ResponseEntity.ok(dietPlan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/submitdietPlan")
    public ResponseEntity<DietPlan> addDietPlan(@RequestBody DietPlan dietPlan) {
        System.out.println(dietPlan);
        DietPlan savedDietPlan = dietPlanService.addDietPlan(dietPlan);
        return new ResponseEntity<>(savedDietPlan, HttpStatus.CREATED);
    }

    @Autowired
    private MedicinePlanService medicinePlanService;
    @GetMapping("/getmedicinePlan")
    public ResponseEntity<List<MedicinePlan>> getMedicinePlan(@RequestParam String phoneNumber) {
        List<MedicinePlan> medicinePlans = medicinePlanService.findByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(medicinePlans);
    }
}
