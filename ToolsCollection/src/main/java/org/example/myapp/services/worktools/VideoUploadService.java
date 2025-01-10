package org.example.myapp.services.worktools;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class VideoUploadService {
    private final Path uploadLocation = Paths.get("/path/to/upload/directory");

    public void uploadVideo(MultipartFile videoFile) throws IOException {
        if (videoFile.isEmpty()) {
            throw new IOException("Empty file");
        }

        Path filePath = uploadLocation.resolve(videoFile.getOriginalFilename());
        videoFile.transferTo(filePath);
    }
}
