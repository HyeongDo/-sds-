package com.multi.student.recommend;

public class Myitem {

    private int img;
    private String name;
    private String address;
    private String cal;

    public Myitem(int img, String name,String address,String cal) {
        this.img = img;
        this.name = name;
        this.address=address;
        this.cal=cal;
    }


    public Integer getImg() {
        return img;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getCal() {
        return cal;
    }

}
