package org.example.myapp.controller.worktools;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.myapp.services.worktools.TranslationFileTransferService;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class translateController {

    // 自动注入 TranslationFileTransferService 实例
    @Autowired
    private TranslationFileTransferService service;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("sourceLang") String sourceLang,
                                                   @RequestParam("targetLang") String targetLang,
                                                   Model model) {
        if (!file.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                String timestamp = dateFormat.format(new Date());

                String originalFileName = file.getOriginalFilename();
                String newFileName = timestamp + ".txt";

                String tempDir = "E:/temp/";
                String tempFilePath = tempDir + newFileName;
                file.transferTo(new File(tempFilePath));

                String outputFilePath = tempDir + timestamp + ".srt";
                boolean translationSuccessful = service.documentTranslationExamples(tempFilePath, outputFilePath, sourceLang, targetLang);

                if (translationSuccessful) {
                    return ResponseEntity.ok("successful");
                } else {
                    return ResponseEntity.ok("failed");
                }

            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.ok("failed");
            }
        }

        return ResponseEntity.ok("failed");
    }
}
