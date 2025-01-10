package org.example.myapp.controller.worktools;

import org.apache.commons.text.StringEscapeUtils;
import org.example.myapp.services.worktools.TextRemovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
public class TextRemovalController {

    @Autowired
    private TextRemovalService textRemovalService;

    @PostMapping(value = "/removeText", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] handleTextRemoval(@RequestParam(value = "files", required = false) MultipartFile[] files,
                                    @RequestParam(value = "file", required = false) MultipartFile file,
                                    @RequestParam("textToRemove") String textToRemove,
                                    HttpServletResponse response) throws IOException {
        // Combine the files and file parameters into one array
        List<MultipartFile> allFiles = new ArrayList<>();
        if (files != null) {
            allFiles.addAll(Arrays.asList(files));
        }
        if (file != null) {
            allFiles.add(file);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try(ZipOutputStream zos = new ZipOutputStream(baos)) {
            for (MultipartFile multipartFile : allFiles) {
                String unescapedTextToRemove = StringEscapeUtils.unescapeHtml4(textToRemove);

                File localFile = File.createTempFile("tempfile", ".tmp");
                try (InputStream is = multipartFile.getInputStream(); FileOutputStream fos = new FileOutputStream(localFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Failed to save uploaded file", e);
                }

                String[] targetTexts = unescapedTextToRemove.split(",");
                byte[] processedFileBytes = textRemovalService.removeTextFromFile(localFile.getAbsolutePath(), targetTexts, multipartFile.getOriginalFilename());

                ZipEntry zipEntry = new ZipEntry(multipartFile.getOriginalFilename());
                zos.putNextEntry(zipEntry);
                zos.write(processedFileBytes);
                zos.closeEntry();
            }
        }
        response.setHeader("Content-Disposition", "attachment; filename=output.zip");
        return baos.toByteArray();
    }

    @PostMapping(value = "/replaceText", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] handleTextReplacement(@RequestParam(value = "files", required = false) MultipartFile[] files,
                                        @RequestParam(value = "file", required = false) MultipartFile file,
                                        @RequestParam("textToReplace") String textToReplace,
                                        @RequestParam("newText") String newText,
                                        HttpServletResponse response) throws IOException {
        // Combine the files and file parameters into one array
        List<MultipartFile> allFiles = new ArrayList<>();
        if (files != null) {
            allFiles.addAll(Arrays.asList(files));
        }
        if (file != null) {
            allFiles.add(file);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try(ZipOutputStream zos = new ZipOutputStream(baos)) {
            for (MultipartFile multipartFile : allFiles) {
                String unescapedTextToReplace = StringEscapeUtils.unescapeHtml4(textToReplace);
                String unescapedNewText = StringEscapeUtils.unescapeHtml4(newText);

                File localFile = File.createTempFile("tempfile", ".tmp");
                try (InputStream is = multipartFile.getInputStream(); FileOutputStream fos = new FileOutputStream(localFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Failed to save uploaded file", e);
                }

                String[] targetTexts = unescapedTextToReplace.split(",");
                String[] newTexts = unescapedNewText.split(",");
                byte[] processedFileBytes = textRemovalService.replaceTextFromFile(localFile.getAbsolutePath(), targetTexts, newTexts, multipartFile.getOriginalFilename());

                ZipEntry zipEntry = new ZipEntry(multipartFile.getOriginalFilename());
                zos.putNextEntry(zipEntry);
                zos.write(processedFileBytes);
                zos.closeEntry();
            }
        }
        response.setHeader("Content-Disposition", "attachment; filename=output.zip");
        return baos.toByteArray();
    }
}
