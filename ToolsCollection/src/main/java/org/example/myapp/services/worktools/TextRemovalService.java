package org.example.myapp.services.worktools;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class TextRemovalService {

    private String unescapeHtml(String html) {
        return StringEscapeUtils.unescapeHtml4(html);
    }

    public byte[] removeTextFromFile(String filePath, String[] targetTexts, String originalFilename) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            String newContent = content;
            for (String targetText : targetTexts) {
                String unescapedTargetText = unescapeHtml(targetText);
                newContent = newContent.replace(unescapedTargetText, "");
            }
            return newContent.getBytes();
        } catch (IOException e) {
            throw new RuntimeException("无法删除文本", e);
        }
    }

    public byte[] replaceTextFromFile(String filePath, String[] targetTexts, String[] newTexts, String originalFilename) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            String newContent = content;

            for (int i = 0; i < targetTexts.length; i++) {
                String unescapedTargetText = unescapeHtml(targetTexts[i]);
                newContent = newContent.replace(unescapedTargetText, newTexts[i]);
            }

            return newContent.getBytes();
        } catch (IOException e) {
            throw new RuntimeException("无法替换文本", e);
        }
    }
}