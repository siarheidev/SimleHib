package com.dev.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class TestTaskController {

    @RequestMapping(value="/singleUpload")
    public String singleUpload(){
        return "singleUpload";
    }

    @RequestMapping(value="/singleSave", method= RequestMethod.POST )
    public String singleSave(@RequestParam("file") MultipartFile file){
        String fileName = null;
        String line = null;
        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
                System.out.println("File name: " + fileName);
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "singleUpload";
            }
        }
        return "ok";
    }

}
