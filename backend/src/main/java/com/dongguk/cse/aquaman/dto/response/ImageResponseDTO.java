package com.dongguk.cse.aquaman.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageResponseDTO {
    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;

    public ImageResponseDTO(){

    }
    public ImageResponseDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
