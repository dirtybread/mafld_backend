package zjubiomedit.mafld_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zjubiomedit.mafld_backend.entity.SportItem;
import zjubiomedit.mafld_backend.entity.SportLog;
import zjubiomedit.mafld_backend.service.SportItemService;
import zjubiomedit.mafld_backend.service.SportLogService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sport")
public class SportController {
    @Autowired
    private SportItemService sportItemService;

    @GetMapping("/getItems")
    public List<SportItem> queryItemsByType(@RequestParam String type) {
        System.out.println(type);
        return sportItemService.findItemsByType(type);
    }

    @Autowired
    private SportLogService sportLogService;

    @PostMapping("/submit")
    public ResponseEntity<SportLog> addSportLog(@RequestBody SportLog sportLog) {
        System.out.println(sportLog);
        SportLog savedSportLog = sportLogService.addSportLog(sportLog);
        return new ResponseEntity<>(savedSportLog, HttpStatus.CREATED);
    }

    @GetMapping("/getsportLog")
    public ResponseEntity<Map<String, Object>> getLatestRecords(@RequestParam String phoneNumber) {
        SportLog latestSportLog = sportLogService.findLatestByPhoneNumber(phoneNumber);
        int sportCnt = sportLogService.countTodaySportLogs(phoneNumber);
        Map<String, Object> response = new HashMap<>();
        response.put("sportCnt", sportCnt);

        if (latestSportLog != null) {
            response.put("sportDate", latestSportLog.getSportDate());
            response.put("intensity", latestSportLog.getIntensity());
            response.put("durationTime", latestSportLog.getDurationTime());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.ok(response); // 即使没有最新记录，也返回当前日期的记录次数
        }
    }

    @GetMapping("/getsporthistory")
    public ResponseEntity<List<SportLog> > getSportHistory(@RequestParam String phoneNumber) {
        List <SportLog> sportLogs = sportLogService.getSportHistory(phoneNumber);
        return ResponseEntity.ok(sportLogs);

    }
}
