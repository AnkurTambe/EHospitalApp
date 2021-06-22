package com.example.ehospitalapp.model;

public class DashboardModel {

    private int image;
    private String text;

    public DashboardModel(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}
