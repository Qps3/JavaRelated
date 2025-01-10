package org.example.myapp.controller.worktools;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.example.myapp.services.worktools.FileTransferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
public class VideoUploadController {

    @Resource
    private FileTransferService fileTransferService;

    @CrossOrigin(origins = "http://localhost:8080")  // 允许跨域请求
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            fileTransferService.uploadFile(file);
            return "uploadSuccess"; // 返回上传成功页面
        } catch (IOException | JSchException | SftpException e) {
            e.printStackTrace();
            return "uploadFailure"; // 返回上传失败页面
        }
    }
}
