package com.wisn.sort;

public class ProductBean {
    public int num=0;
    public String Name="";

    public ProductBean(int num) {
        this.num = num;
        Name ="test"+ num;
    }

    @Override
    public String toString() {
        return "{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
