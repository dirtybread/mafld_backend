package zjubiomedit.mafld_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zjubiomedit.mafld_backend.entity.DietLog;
import zjubiomedit.mafld_backend.service.DietLogService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/diet")
public class DietController {


    //规定图片存放地址，也可以在配置文件中设置
//    @Value("${file.upload-dir}")
    private String uploadDirPath;
    @PostMapping("/uploadImage/{phoneNumber}")
    public ResponseEntity<String> uploadFile(@PathVariable("phoneNumber") String phoneNumber, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {

            try {
                // 创建用户特定的文件保存目录
                Path userUploadDir = Paths.get(uploadDirPath, phoneNumber);
                if (!Files.exists(userUploadDir)) {
                    Files.createDirectories(userUploadDir);
                }

                // 保存文件到服务器
                String fileName = file.getOriginalFilename();
                Path filePath = userUploadDir.resolve(fileName);
                file.transferTo(filePath.toFile());
                // 生成公开访问的 URL
                String fileUrl = uploadDirPath + "/" + phoneNumber + "/" + fileName;
                // 返回成功响应
                return ResponseEntity.ok(fileUrl);
            } catch (IOException e) {
                return ResponseEntity.internalServerError().body("Failed to save file");
            }
        } else {
            return ResponseEntity.badRequest().body("Empty file");
        }
    }

    @Autowired
    private DietLogService dietLogService;
    @PostMapping("/submitdiet")
    public  ResponseEntity<DietLog> saveLog(@RequestBody DietLog dietLog){
        System.out.println(dietLog);
        DietLog savedDietLog=dietLogService.saveDietLog(dietLog);
        return ResponseEntity.ok(savedDietLog);
    }

    @GetMapping("/getdietlog")
    public ResponseEntity<List<DietLog>> getDietLogs(
            @RequestParam String phoneNumber,
            @RequestParam String date) {
        List<DietLog> dietLogs = dietLogService.getDietLogs(phoneNumber, date);
        System.out.println(dietLogs);
        return ResponseEntity.ok(dietLogs);
    }

    @GetMapping("/getdiethistory")
    public ResponseEntity<List<DietLog>> getDietHistory(
            @RequestParam String phoneNumber) {
        List<DietLog> dietLogs = dietLogService.getDietHistory(phoneNumber);
        System.out.println(dietLogs);
        return ResponseEntity.ok(dietLogs);
    }

}
