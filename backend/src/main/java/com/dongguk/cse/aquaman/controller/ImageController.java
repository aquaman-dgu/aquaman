package com.dongguk.cse.aquaman.controller;

import com.dongguk.cse.aquaman.dto.response.ImageResponseDTO;
import com.dongguk.cse.aquaman.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping(value = "/api/upload",  consumes = "multipart/form-data")
    public ResponseEntity<ImageResponseDTO> downloadImage(@RequestPart("file") MultipartFile file,
                                                          @RequestParam("length") double length,
                                                          @RequestParam("weight") double weight ,
                                                          @RequestParam("feed") double feed)
            throws IOException {
        byte[] bytes = file.getBytes();
        try {
            ImageResponseDTO response = imageService.sendToFlask(bytes, length, weight, feed);
            if (response.getStatus().equals("success"))
                return ResponseEntity.status(200).body(response);
            else return ResponseEntity.status(500).body(null);
        } catch (HttpServerErrorException e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}

