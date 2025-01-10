package org.example.myapp.services.worktools;

import com.deepl.api.*;
import java.io.File;

public class Example {
    private Translator translator;

    public Example(String apiKey) {
        translator = new Translator(apiKey);
    }

    public boolean documentTranslationExamples(String inputFilePath, String outputFilePath, String sourceLang, String targetLang) {
        try {
            File inputFile = new File(inputFilePath);
            File outputFile = new File(outputFilePath);
            translator.translateDocument(inputFile, outputFile, sourceLang, targetLang);
            System.out.println("Document translation completed successfully.");
        } catch (DocumentTranslationException exception) {
            DocumentHandle handle = exception.getHandle();
            System.out.printf("Error after uploading %s, document handle: id: %s key: %s%n",
                    exception.getMessage(),
                    handle.getDocumentId(),
                    handle.getDocumentKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        String apiKey = "02efe5de-ca5a-6aa8-acad-de534687d3b6:fx"; // Replace with your Deepl API key
        Example example = new Example(apiKey);

        // Replace the following file paths and language codes with your desired values
        String inputFilePath = "E:/desktop/123.txt";
        String outputFilePath = "E:/desktop/1234.srt";
        String sourceLang = "en";
        String targetLang = "zh";

        example.documentTranslationExamples(inputFilePath, outputFilePath, sourceLang, targetLang);
    }
}
