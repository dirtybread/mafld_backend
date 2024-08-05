package zjubiomedit.mafld_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zjubiomedit.mafld_backend.entity.GluLog;
import zjubiomedit.mafld_backend.service.GluLogService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/glu")
public class GluController {
    @Autowired
    private GluLogService gluLogService;
    @PostMapping("/submit")
    public ResponseEntity<GluLog> submitGluLog(@RequestBody GluLog gluLog) {
        GluLog savedGluLog = gluLogService.save(gluLog);
        return ResponseEntity.ok(savedGluLog);
    }
    @GetMapping("/getgluLog")
    public ResponseEntity<Map<String, Object>> getLatestRecords(@RequestParam String phoneNumber) {
        GluLog latestGluLog = gluLogService.findLatestByPhoneNumber(phoneNumber);
        int gluCnt = gluLogService.countTodayGluLogs(phoneNumber);
        Map<String, Object> response = new HashMap<>();
        response.put("gluCnt", gluCnt);

        if (latestGluLog != null) {
            response.put("gluDate", latestGluLog.getGluDate());
            response.put("glu", latestGluLog.getGlu());
            response.put("gluTimepoint", latestGluLog.getGluTimepoint());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.ok(response); // 即使没有最新记录，也返回当前日期的记录次数
        }
    }

    @GetMapping("/getgluhistory")
    public ResponseEntity<List<GluLog>> getGluHistory(@RequestParam String phoneNumber) {
        List <GluLog> gluLogs = gluLogService.getGluHistory(phoneNumber);
        return ResponseEntity.ok(gluLogs);

    }
}
