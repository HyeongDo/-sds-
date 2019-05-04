package com.multi.student.recommend;

public class Productadd {
    private int imgID;
    private String name;
    private String cal;


    public Productadd(int imgID, String name, String cal) {
        this.imgID = imgID;
        this.name = name;
        this.cal = cal;

    }


    public int getImgID() {
        return imgID;
    }

    public String getName() {
        return name;
    }

    public String getCal() { return cal; }


}
