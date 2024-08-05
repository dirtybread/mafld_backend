package zjubiomedit.mafld_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zjubiomedit.mafld_backend.entity.MedicineLog;
import zjubiomedit.mafld_backend.service.MedicineLogService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    private MedicineLogService medicineLogService;

    @PostMapping("/submit")
    public ResponseEntity<MedicineLog> addMedicineLog(@RequestBody MedicineLog medicineLog) {
        System.out.println(medicineLog);
        MedicineLog savedMedicineLog = medicineLogService.addMedicineLog(medicineLog);
        return new ResponseEntity<>(savedMedicineLog, HttpStatus.CREATED);
    }

    @GetMapping("/getmedicineLog")
    public ResponseEntity<Map<String, Object>> getLatestRecords(@RequestParam String phoneNumber) {

        MedicineLog latestMedicineLog = medicineLogService.findLatestByPhoneNumber(phoneNumber);
        int medicineCnt = medicineLogService.countTodayMedicineLogs(phoneNumber);
        Map<String, Object> response = new HashMap<>();
        response.put("medicineCnt", medicineCnt);

        if (latestMedicineLog != null) {
            response.put("medicineDate", latestMedicineLog.getMedicineDate());
            response.put("medicineTime", latestMedicineLog.getMedicineTime());
            response.put("medicineName", latestMedicineLog.getMedicineName());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.ok(response); // 即使没有最新记录，也返回当前日期的记录次数
        }
    }

    @GetMapping("/getmedicinehistory")
    public ResponseEntity<List<MedicineLog>> getMedicineHistory(@RequestParam String phoneNumber) {
        List <MedicineLog> medicineLogs = medicineLogService.getMedicineHistory(phoneNumber);
        return ResponseEntity.ok(medicineLogs);

    }
}
