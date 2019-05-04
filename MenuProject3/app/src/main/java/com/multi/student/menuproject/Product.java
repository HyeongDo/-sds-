package com.multi.student.menuproject;

public class Product {

    private boolean checklike;
    private boolean checkitem;
    private int imageId;
    private String name;
    private String end;
    private String cal;
    private String count;

    public Product(boolean checkitem,boolean checklike, int imageId, String name, String count, String end, String cal) {

        this.checkitem=checkitem;
        this.checklike = checklike;
        this.imageId = imageId;
        this.name = name;
        this.count = count;
        this.end = end;
        this.cal = cal;

    }

    public boolean getChecklike(){
        return checklike;
    }

    public boolean getCheckitem(){

        return checkitem;
    }

    public String getCount() {
        return count;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getEnd() {
        return end;
    }

    public String getCal() {
        return cal;
    }

}

