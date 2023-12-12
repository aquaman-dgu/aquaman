package com.dongguk.cse.aquaman.service;

import com.dongguk.cse.aquaman.dto.response.ImageResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
@Slf4j
public class ImageService {
    @Value("${flask.server.url}")
    private String flaskServerUrl;
    Logger logger = LoggerFactory.getLogger(ImageService.class);

    public ImageResponseDTO sendToFlask(byte[] file, double length, double weight, double feed) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        try {
            // 헤더와 바디를 갖는 HttpEntity 생성
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", new ByteArrayResource(file) {
                @Override
                public String getFilename() {
                    return "image.jpg";
                }
            });
            body.add("length", length);
            body.add("weight", weight);
            body.add("feed", feed);

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            ResponseEntity<ImageResponseDTO> responseEntity = restTemplate.postForEntity(flaskServerUrl+"/image", requestEntity, ImageResponseDTO.class);
            System.out.println(responseEntity);
            ImageResponseDTO imageResponse = responseEntity.getBody();
                        if (imageResponse.getStatus().equals("success")){

                String directoryPath = "C:\\Users\\roger\\aquaman-ai\\disease\\disease\\"+ imageResponse.getValue();

                // 주어진 경로에 있는 디렉토리 객체 생성
                File dir = new File(directoryPath);

                // 디렉토리가 존재하고 디렉토리인지 확인
                if (dir.exists() && dir.isDirectory()) {
                    // 디렉토리 내의 하위 디렉토리 목록 가져오기
                    String[] subdirectories = dir.list();

                    // 각 하위 디렉토리에 대해 이름이 "disease"인 디렉토리에서 파일 목록 출력
                    if (subdirectories != null) {
                        for (String subdirectory : subdirectories) {
                            if (subdirectory.equals("disease")){
                            File subDir = new File(dir, subdirectory);
                            if (subDir.exists() && subDir.isDirectory()) {
                                // 해당 하위 디렉토리 내의 파일 목록 가져오기
                                String[] filenames = subDir.list();

                                // 파일 목록 출력
                                if (filenames != null) {
                                    System.out.println("Files in subdirectory 'disease':");
                                    for (String filename : filenames) {
                                        String path = directoryPath + "\\" + filename;
                                        System.out.println(path);
                                        arrayList.add(path);
                                    }
                                } else {
                                    System.out.println("No files in subdirectory 'disease'.");
                                }
                            }
                        }
                        }
                    } else {
                        System.out.println("No subdirectories found in the specified directory.");
                    }
                } else {
                    System.out.println("The specified directory does not exist or is not a directory.");
                }
            }
            imageResponse.setImgPath(arrayList);
            return  imageResponse;
        } catch (HttpServerErrorException e) {
            logger.info(e.getMessage());
            return null;
        }
    }
}
