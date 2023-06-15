//package com.sci.kids.controllers;
//
//import com.sci.kids.utils.FileUploadUtil;
//import java.io.IOException;
//import java.util.Date;
//import org.springframework.http.MediaType;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//@CrossOrigin(origins = "*", allowCredentials = "false")
//@RestController
//@RequestMapping("/kids")
//public class KidsController {
//
//  @PostMapping(value = "/upload",
//      consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
//      produces = {MediaType.TEXT_HTML_VALUE})
//  public String saveUser(@RequestParam("image") MultipartFile multipartFile)
//      throws IOException, InterruptedException {
//    System.out.println("here ***");
//    String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//
//    String uploadDir = "D:\\kid-photo\\" + new Date().getTime();
//
//    FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//
////    ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "D:\\run.bat");
////    builder.redirectErrorStream(true);
////    Process process = builder.start();
//
//    String path = "D:\\run.bat";
//    Process p = Runtime.getRuntime().exec("cmd /c start /wait " + path);
//    p.waitFor();
//
////    return new RedirectView("/kids", true);
//    return "test";
//  }
//}