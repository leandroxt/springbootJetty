package com.project.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.security.SecureRandom;

/**
 * Created by leandro on 13/07/16.
 */
@Controller
public class FileUploadController {

    private SecureRandom random = new SecureRandom();

    @Autowired
    private Environment environment;

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile) {
        String filename = uploadFile.getOriginalFilename();
        String directory = environment.getProperty("app.path.uploadFile");
        String filepath = Paths.get(directory, randomString(filename)).toString();

        try {
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(filepath)));

            stream.write(uploadFile.getBytes());
            stream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private String randomString(String filename) {
        String[] fileExtension = filename.split("\\.");
        return new BigInteger(130, random).toString(32).concat("." + fileExtension[fileExtension.length - 1]);
    }

}
