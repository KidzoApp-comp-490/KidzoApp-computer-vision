package com.sci.kids.controllers;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class FileController {

    @GetMapping("/file")
    public String getFileContent() throws IOException {
        // Replace the file path with your desired file path
        String filePath = "C:/python/yolov7/class.txt";
        // Load the file from the file system
        Resource resource = new FileSystemResource(filePath);
        InputStream inputStream = resource.getInputStream();
        // Read the file content into a string
        byte[] fileBytes = FileCopyUtils.copyToByteArray(inputStream);
        String fileContent = new String(fileBytes, StandardCharsets.UTF_8);
         String str =  encryption(fileContent ,3);
        return fileContent;
    }
    public static String encryption(String text, int shift) {
        boolean encrypt = true;
        StringBuilder result = new StringBuilder();

        if (!encrypt) {
            shift = -shift; // Invert the shift for decryption
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                int asciiOffset = Character.isUpperCase(ch) ? 65 : 97; // Determine ASCII offset based on uppercase or lowercase
                int shifted = (ch - asciiOffset + shift + 26) % 26; // Apply shift and wrap around the alphabet
                result.append((char) (shifted + asciiOffset));
            } else {
                result.append(ch); // Preserve non-alphabetic characters
            }
        }

        return result.toString();
    }
}
