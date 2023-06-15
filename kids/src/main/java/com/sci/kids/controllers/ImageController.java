package com.sci.kids.controllers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@CrossOrigin(origins = "*", allowCredentials = "false")
@RestController

public class ImageController {
    @PostMapping({"/upload"})
    public ResponseEntity<String> uploadImage(@RequestBody ImageRequest request) {
        try {
            System.out.println("here = " );
            // Access the base64 image data from the request.getImage() method
            String base64Image = request.getImage();

            // Save the image or process it as per your requirements
            // For example, you can decode the base64 image and save it to a file
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);
            String fileName = "image.jpg"; // Provide a filename or generate a unique one
            String imagePath = "C:\\python\\yolov7\\runs" + fileName; // Provide the actual path to save the image
            Files.write(Paths.get(imagePath), imageBytes);
            System.out.println( Files.write(Paths.get(imagePath), imageBytes));
            // Return a success response
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            // Handle any error occurred during image processing or saving
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image abdel5any");
        }
    }
    public ResponseEntity<byte[]> processImage() {
        try {
            // Launch Anaconda Prompt and run the commands
            String[] commands = {"cmd", "/c", "start", "anaconda prompt", "/k", "conda activate yolov7 && cd C:\\python\\yolov7 && python detect.py --weights yolov7.pt --conf 0.5 --img-size 640 --source runsimage.jpg --name test"};

            ProcessBuilder processBuilder = new ProcessBuilder(commands);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            process.waitFor();
            System.out.println("******1");
            // Wait for 2 seconds
            Thread.sleep(30000);
            System.out.println("******2");
            // Read the resulting image file
            byte[] imageBytes = Files.readAllBytes(Paths.get("C:\\python\\yolov7\\runs\\detect\\test\\runsimage.jpg"));

            // Set the appropriate headers and return the image as a response
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentDispositionFormData("attachment", "processed_image.jpg");
            System.out.println("******3");
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            // Handle any exception that occurs during the process execution
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}


