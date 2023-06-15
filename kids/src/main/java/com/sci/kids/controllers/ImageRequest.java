package com.sci.kids.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowCredentials = "false")
public class ImageRequest {
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
