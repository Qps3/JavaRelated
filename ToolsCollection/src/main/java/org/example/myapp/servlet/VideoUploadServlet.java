package org.example.myapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@WebServlet("/uploadVideo")
public class VideoUploadServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "E:/desktop/新建文件夹 (4)"; // 目标文件夹路径

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fileName = UUID.randomUUID().toString() + ".mp4";
        String filePath = UPLOAD_DIR + File.separator + fileName;

        InputStream inputStream = request.getPart("videoFile").getInputStream();
        Files.copy(inputStream, Paths.get(filePath));

        response.getWriter().println("Video uploaded successfully!");
    }
}
