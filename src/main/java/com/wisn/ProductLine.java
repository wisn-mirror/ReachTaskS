package com.wisn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductLine {

    public List<String> space(String str, int maxlength, int maxNameLength, int count, double price, int maxLine, List<String> list) {
        int getlength = getlength(str);
        System.out.println(" A:" + getlength);
        if (getlength > maxNameLength) {
            if (getlength > maxlength) {
                int lengthIndex = getLengthIndex(str, maxlength);
                list.add(str.substring(0, lengthIndex));
                String substring = str.substring(lengthIndex, str.length());
                if (list.size() >= maxLine - 1) {
                    int substringlength = getlength(substring);
                    list.add(addSpaceLine(maxlength, maxNameLength, substring, substringlength, count, price));
                } else {
                    space(substring, maxlength, maxNameLength, count, price, maxLine, list);
                }
            } else {
                list.add(str);
                list.add(addSpaceLine(maxlength, maxNameLength, null, 0, count, price));
            }
        } else {
            list.add(addSpaceLine(maxlength, maxNameLength, str, getlength, count, price));
        }
        return list;

    }

    //27，14,X1000,5,1000, 1000.33
    public String addSpaceLine(int maxLength, int maxNameLength, String name, int namelength, int count, double price) {
        String countStr = "X" + String.valueOf(count);
        String priceStr = String.format("¥%.2f", price);
        StringBuilder builder = new StringBuilder();
        if (name != null) {
            if (namelength >= maxNameLength) {
                int lengthIndex = getLengthIndex(name, maxNameLength - 4);
                builder.append(name.substring(0, lengthIndex));
                builder.append("...");
                namelength = maxNameLength - 1;
            } else {
                builder.append(name);
            }
        } else {

        }
        int nameSpace = maxNameLength - namelength;
        int priceSpace = maxLength - maxNameLength - countStr.length() - priceStr.length() - 1;
        System.out.println("BBBBB" + priceSpace);
        if (priceSpace < 0) {
            nameSpace = nameSpace - priceSpace;
        }
        for (int i = 0; i < nameSpace; i++) {
            builder.append(" ");
        }
        builder.append(countStr);
        for (int i = 0; i < priceSpace; i++) {
            builder.append(" ");
        }
        builder.append(priceStr);
        return builder.toString();
    }

    public int getlength(String str) {
        String[] split = str.split("");
        int sum = 0;
        for (String string : split) {
            if (isDouble(string)) sum = sum + 2;
            else sum = sum + 1;
        }
        return sum;
    }

    public int getLengthIndex(String str, int maxLength) {
        int index = 0;
        String[] split = str.split("");
        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            String string = split[i];
            if (sum == (maxLength - 1)) {
                if ((i + 1) < split.length) {
                    String temp = split[i + 1];
                    if (isDouble(temp)) {
                        index = i;
                    } else {
                        index = i + 1;
                    }
                } else {
                    index = i;
                }
            } else if (sum == maxLength) {
                index = i;
            }
            if (isDouble(string)) sum = sum + 2;
            else sum = sum + 1;
        }
        return index;
    }

    public static boolean isDbcCase(char c) {
        // 基本拉丁字母（即键盘上可见的，空格、数字、字母、符号）
        if (c >= 32 && c <= 127) {
            return true;
        }
        // 日文半角片假名和符号
        else if (c >= 65377 && c <= 65439) {
            return true;
        }
        return false;
    }


    public boolean isDouble(String string) {
        int n = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            n = (int) c;
            if (!isDbcCase(c)) {
                return true;
            }
            if (!(19968 <= n && n < 40869)) {
                return false;
            }
        }
        return true;
    }


    public static String formatNumber(double number) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(number);
    }

    public static void main(String[] args) {
//        System.out.println(formatNumber(14321432.432432));
       /* ProductLine line = new ProductLine();
        String str = "水果干20g水果g水果干干干干干干干干干干fff";
//        String str = "X1000";
        System.out.println(" "+line.getlength(str));
//        System.out.println(line.isDouble("中"));
//        System.out.println(line.isDouble("，"));
//        System.out.println(line.isDouble("。"));
//        System.out.println(line.isDouble(","));
//        System.out.println(isDbcCase(",".charAt(0)));
//        System.out.println(isDbcCase("。".charAt(0)));
//        System.out.println(isDbcCase("，".charAt(0)));

        ArrayList<String> arrayList = new ArrayList<>();
        line.space(str, 27, 14, 1, 10.33, 5, arrayList);

        line.space(str, 27, 14, 20, 10.33, 5, arrayList);

        line.space(str, 27, 14, 300, 100.33, 5, arrayList);

        line.space(str, 27, 14, 3000, 1000.33, 5, arrayList);
        for (String string : arrayList) {
            System.out.println(string + ":" + line.getlength(string));
        }*/
//        int length = 5;
//        String codeFormat = "%0"+String.valueOf(length)+"d";//%03d
//        String str = String.format(codeFormat,499);
//        System.out.println(str);

        ProductLine productLine = new ProductLine();
        System.out.println(productLine.getlength("合计:"));
        System.out.println(productLine.getlength("¥32.33"));
        System.out.println("---------");
        String[] split = "hello".split("");
        for (String str : split) {
            System.out.println(str);
        }
        System.out.println("---------");
        System.out.println("-----ddd----");
        String aaa="hello中国";
        for (int i=0;i< aaa.length();i++) {
            System.out.println(aaa.charAt(i));
        }
        System.out.println("-----ddd----");


    }

}
