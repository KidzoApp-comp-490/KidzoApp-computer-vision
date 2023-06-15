package com.sci.kids.controllers;
public class DetectionRequest {
    private String weights;
    private double conf;
    private int imgSize;
    private String source;

    // Default constructor (required for JSON deserialization)
    public DetectionRequest() {
    }

    // Getters and setters

    public String getWeights() {
        return weights;
    }

    public void setWeights(String weights) {
        this.weights = weights;
    }

    public double getConf() {
        return conf;
    }

    public void setConf(double conf) {
        this.conf = conf;
    }

    public int getImgSize() {
        return imgSize;
    }

    public void setImgSize(int imgSize) {
        this.imgSize = imgSize;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
