package zjubiomedit.mafld_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zjubiomedit.mafld_backend.entity.HealthFile;
import zjubiomedit.mafld_backend.entity.HealthLog;
import zjubiomedit.mafld_backend.service.HealthFileService;
import zjubiomedit.mafld_backend.service.HealthLogService;

@RestController
@RequestMapping("/health")
public class HealthIndexController {

    @Autowired
    private HealthLogService healthLogService;

    @PostMapping("submitQuicklog")
    public ResponseEntity<HealthLog> addHealthLog(@RequestBody HealthLog healthLog) {
        return ResponseEntity.ok(healthLogService.save(healthLog));
    }


    @GetMapping("/getbp")
    public ResponseEntity<HealthLog> getLatestBloodPressureByPhoneNumber(@RequestParam String phoneNumber) {
        HealthLog latestBloodPressure = healthLogService.findLatestBloodPressureByPhoneNumber(phoneNumber);
        if (latestBloodPressure != null) {
            return ResponseEntity.ok(latestBloodPressure);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getwaist")
    public ResponseEntity<HealthLog> getLatestWaistByPhoneNumber(@RequestParam String phoneNumber) {
        HealthLog latestWaist = healthLogService.findLatestWaistByPhoneNumber(phoneNumber);
        if (latestWaist != null) {
            return ResponseEntity.ok(latestWaist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Autowired
    private HealthFileService healthFileService;

    @GetMapping("/gethealthFile")
    public ResponseEntity<HealthFile> getLatestFile(@RequestParam String phoneNumber) {
//        System.out.println(phoneNumber);
        HealthFile result = healthFileService.getLatestRecords(phoneNumber);
        System.out.println(result);
        return ResponseEntity.ok(result);
    }


    @PostMapping("/submithealthFile")
    public ResponseEntity<HealthFile> addHeathFile(@RequestBody HealthFile healthFile) {
        System.out.println(healthFile);
        return ResponseEntity.ok(healthFileService.save(healthFile));
    }

}
