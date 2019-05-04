package com.multi.student.listviewproject;

/*리스트 뷰의 아이템 한 개를 위한 데이터를 저장하는 객체*/
public class Product {
    private int imgId;//이미지 id
    private String name;//상품이름
    private int count;//상품수량

    public Product(int imgId, String name,int count) {
        this.imgId = imgId;
        this.name = name;
        this.count=count;
    }

    public int getImgId() {
        return imgId;
    }

    public String getName() {
        return name;
    }

    public int getCount(){
        return count;
    }
}
