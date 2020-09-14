package com.wisn.sort;

import java.util.*;

public class test {
    public static void main( String[] arg){
        List<ProductBean> productBean=new ArrayList<>();
        for(int i=0;i<10;i++){
            productBean.add(new ProductBean(100+i));
        }
        productBean.add(new ProductBean(1));
        productBean.add(new ProductBean(3));
        productBean.add(new ProductBean(1));
        productBean.add(new ProductBean(40));
        productBean.add(new ProductBean(5));
        productBean.add(new ProductBean(10));
        productBean.add(new ProductBean(9));
        productBean.add(new ProductBean(77));
        for(int i=0;i<10;i++){
            productBean.add(new ProductBean(200+i));
        }
        for(int i=0;i<10;i++){
            productBean.add(new ProductBean(150+i));
        }
      /*  Collections.sort(productBean, new Comparator<ProductBean>() {
            @Override
            public int compare(ProductBean o1, ProductBean o2) {
                if (o1.num >= o2.num) return 1;
                else return -1;
            }
        });*/
        List<ProductBean> productBeans = productBean.subList(10, 18);
//        Arrays.sort(,10,17,new Comparator<ProductBean>() {
//            @Override
//            public int compare(ProductBean o1, ProductBean o2) {
//                if (o1.num >= o2.num) return 1;
//                else return -1;
//            }
//        });
        Collections.sort(productBeans, new Comparator<ProductBean>() {
            @Override
            public int compare(ProductBean o1, ProductBean o2) {
                if (o1.num >= o2.num) return 1;
                else return -1;
            }
        });
//        productBean.removeAll(productBeans);
//        productBean.addAll(10,productBeans);
        for(ProductBean productBean1:productBean){
            System.out.println(productBean1.toString());
        }
    }
}
