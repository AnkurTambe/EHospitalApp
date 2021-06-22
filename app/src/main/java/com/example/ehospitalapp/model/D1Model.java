package com.example.ehospitalapp.model;

public class D1Model {
    private String txt1;
    private String txt2;
    private String txt3;
    private int img;


    public D1Model(String txt1, String txt2, String txt3, int img) {
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.txt3 = txt3;
        this.img = img;
    }


    public String getTxt1() {
        return txt1;
    }

    public String getTxt2() {
        return txt2;
    }

    public String getTxt3() {
        return txt3;
    }

    public int getImg() {
        return img;
    }
}