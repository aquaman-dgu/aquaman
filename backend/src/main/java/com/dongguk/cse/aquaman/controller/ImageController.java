package com.dongguk.cse.aquaman.controller;

import com.dongguk.cse.aquaman.dto.response.ImageResponseDTO;
import com.dongguk.cse.aquaman.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping(value = "/api/upload",  consumes = "multipart/form-data")
    public String downloadImage(@RequestPart("file") MultipartFile file,
                                                          @RequestParam("length") double length,
                                                          @RequestParam("weight") double weight ,
                                                          @RequestParam("fee") double feed,
                                                          Model model
                                                          )
            throws IOException {
        byte[] bytes = file.getBytes();
        try {
            // ImageService에서 반환된 DTO를 얻어옴
            ImageResponseDTO response = imageService.sendToFlask(bytes, length, weight, feed);

            // Thymeleaf 모델에 속성 추가
            model.addAttribute("status", response.getStatus());
            model.addAttribute("message", response.getMessage());
            model.addAttribute("value", response.getValue());
            model.addAttribute("length", response.getLength());
            model.addAttribute("weight", response.getWeight());
            model.addAttribute("imgPath", response.getImgPath());

            // Thymeleaf 템플릿 이름 반환 (templates 폴더 아래의 HTML 파일명)
            return "moniter_result";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error processing image", e);
        }
    }
}

