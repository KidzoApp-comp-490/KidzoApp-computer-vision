package com.sci.kids.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@CrossOrigin(origins = "*", allowCredentials = "false")
@RestController
public class DetectionController {
    @PostMapping("/detection")
    public String runDetection(@RequestBody DetectionRequest detectionRequest) {
        try {
            // Open Anaconda prompt and navigate to the specified path
            String command1 = "cmd.exe /c start \"\" \"C:\\Users\\Mohamed Mabrouk\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Anaconda3 (64-bit)\\Anaconda Prompt (anaconda3).lnk\" /k \"cd C:/python/yolov7 && conda activate yolov7 && cd C:\\python\\yolov7 && python detect.py --weights best.pt --conf 0.4 --img-size 640 --source 0\"";

            Process process1 = Runtime.getRuntime().exec(command1);
            process1.waitFor();

            return "Detection completed";
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            return "Error executing the detection";
        }
    }
}
