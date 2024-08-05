package zjubiomedit.mafld_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zjubiomedit.mafld_backend.entity.CheckLog;
import zjubiomedit.mafld_backend.service.CheckLogService;

import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckController {
    @Autowired
    private CheckLogService checkLogService;

//    @PostMapping("/submitcheckLog")
//    public ResponseEntity<?> submitCheckLog(@RequestBody CheckLog checkLog) {
//        checkLog = checkLogService.saveCheckLog(checkLog);
//        return ResponseEntity.ok(checkLog);
//    }
//
//    @Value("${file.upload-dir}")
//    private String uploadDirPath;
//    @PostMapping("/uploadImage")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        if (!file.isEmpty()) {
//            try {
//                // 创建文件保存的目录
//                Path uploadDir = Paths.get(uploadDirPath);
//                System.out.println("CheckController报告上传"+uploadDir);
//
//                // 保存文件到服务器
//                String fileName = file.getOriginalFilename();
//                Path filePath = uploadDir.resolve(fileName);
//                file.transferTo(filePath.toFile());
//
//                // 返回成功响应
//                return ResponseEntity.ok("File uploaded successfully");
//            } catch (IOException e) {
//                return ResponseEntity.internalServerError().body("Failed to save file");
//            }
//        } else {
//            return ResponseEntity.badRequest().body("Empty file");
//        }
//    }

    @PostMapping("/submitcheckLog")
    public  ResponseEntity<CheckLog> saveLog(@RequestBody CheckLog checkLog){
        System.out.println(checkLog);
        CheckLog savedCheckLog=checkLogService.saveCheckLog(checkLog);
        return ResponseEntity.ok(savedCheckLog);
    }


    @GetMapping("/getcheckLog")
    public ResponseEntity<List<CheckLog>> getCheckLogs(@RequestParam String phoneNumber) {
        List<CheckLog> checkLogs = checkLogService.getCheckLogsByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(checkLogs);
    }
}
