package com.example.ehospitalapp.model;

public class D2Model {
    private int img;
    private String txt1;

    public int getImg() {
        return img;
    }

    public String getTxt1() {
        return txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public D2Model(int img, String txt1, String txt2) {
        this.img = img;
        this.txt1 = txt1;
        this.txt2 = txt2;
    }

    private String txt2;

}