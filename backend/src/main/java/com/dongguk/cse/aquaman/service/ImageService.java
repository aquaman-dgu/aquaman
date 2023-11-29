package com.dongguk.cse.aquaman.service;

import com.dongguk.cse.aquaman.dto.response.ImageResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;

@Service
@Slf4j
public class ImageService {
    @Value("${flask.server.url}")
    private String flaskServerUrl;
    Logger logger = LoggerFactory.getLogger(ImageService.class);

    public ImageResponseDTO sendToFlask(byte[] file) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        try {
            String jsonResponse = restTemplate.postForObject(flaskServerUrl + "/image", file, String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            ImageResponseDTO imageResponse = objectMapper.readValue(jsonResponse, ImageResponseDTO.class);
            return  imageResponse;
        }
        catch (HttpServerErrorException e){
            logger.info(e.getMessage());
            return null;
        }
    }
}
