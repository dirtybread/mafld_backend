package zjubiomedit.mafld_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zjubiomedit.mafld_backend.entity.WeightLog;
import zjubiomedit.mafld_backend.service.WeightLogService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/weight")
public class WeightController {
    @Autowired
    private WeightLogService weightLogService;

    @PostMapping("/submit")
    public ResponseEntity<WeightLog> submitWeightLog(@RequestBody WeightLog weightLog) {
        WeightLog savedWeightLog = weightLogService.save(weightLog);
        return ResponseEntity.ok(savedWeightLog);
    }

    @GetMapping("/getweightLog")

    public ResponseEntity<Map<String, Object>> getLatestWeightLogAndCount(@RequestParam String phoneNumber) {
        WeightLog latestWeightLog = weightLogService.findLatestByPhoneNumber(phoneNumber);
        int weightCnt = weightLogService.countTodayWeightLogs(phoneNumber);
        Map<String, Object> response = new HashMap<>();
        response.put("weightCnt", weightCnt);

        if (latestWeightLog != null) {
            response.put("weightDate", latestWeightLog.getWeightDate());
            response.put("weightTime", latestWeightLog.getWeightTime());
            response.put("weight", latestWeightLog.getWeight());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.ok(response); // 即使没有最新记录，也返回当前日期的记录次数
        }
    }

    @GetMapping("/getweighthistory")
    public ResponseEntity<List<WeightLog>> getWeightHistory(@RequestParam String phoneNumber) {
        List <WeightLog> weightLogs = weightLogService.getWeightHistory(phoneNumber);
        return ResponseEntity.ok(weightLogs);

    }
}
