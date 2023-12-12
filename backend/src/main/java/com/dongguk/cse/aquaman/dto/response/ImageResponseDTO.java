package com.dongguk.cse.aquaman.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ImageResponseDTO {
    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;

    @JsonProperty("value")
    private String value;

    private ArrayList<String> imgPath;

    @JsonProperty("length")
    private float length;

    @JsonProperty("weight")
    private float weight;


    public ImageResponseDTO(String status, String message, String value, ArrayList<String> imgPath, float length, float weight) {
        this.status = status;
        this.message = message;
        this.value = value;
        this.imgPath = imgPath;
        this.length = length;
        this.weight = weight;
    }

    public ImageResponseDTO() {

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<String> getImgPath() {
        return imgPath;
    }

    public void setImgPath(ArrayList<String> imgPath) {
        this.imgPath = imgPath;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
