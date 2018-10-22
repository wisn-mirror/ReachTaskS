package com.wisn;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wisn on 2018/6/5 下午1:13.
 * 打印小票排版
 */
public class PrintLineHelper {

    private static final PrintLineHelper manager = new PrintLineHelper();

    public static PrintLineHelper getInstance() {
        return manager;
    }

    /**
     * @param produceName   商品名称
     * @param price1        分摊价格最大支持3位数
     * @param count         数量最大支持3位数
     * @param price2        总价格最大支持3位数
     * @param maxlength     一行打印最大长度
     * @param maxNameLength 商品名的最大长度
     * @param maxLine       最大显示多少行，包括价格数量排版行
     * @param list          最终排版的结果
     * @return
     */
    public List<String> getRefundProductLines(String produceName, double price1, int count, double price2, int maxlength, int maxNameLength, int maxLine, List<String> list) {
        int getlength = getlength(produceName);
        if (getlength > maxNameLength) {
            if (getlength > maxlength) {
                int lengthIndex = getLengthIndex(produceName, maxlength);
                list.add(produceName.substring(0, lengthIndex));
                String substring = produceName.substring(lengthIndex, produceName.length());
                if (list.size() >= maxLine - 1) {
                    int substringlength = getlength(substring);
                    list.add(addRefundSpaceLine(maxlength, maxNameLength, substring, substringlength, price1, count, price2));
                } else {
                    getRefundProductLines(substring, price1, count, price2, maxlength, maxNameLength, maxLine, list);
                }
            } else {
                list.add(produceName);
                list.add(addRefundSpaceLine(maxlength, maxNameLength, null, 0, price1, count, price2));
            }
        } else {
            list.add(addRefundSpaceLine(maxlength, maxNameLength, produceName, getlength, price1, count, price2));
        }
        return list;
    }


    /**
     * 打印商品列表排版
     *
     * @param produceName   商品名称
     * @param maxlength     对应字体下，最大的字符长度
     * @param maxNameLength 最大的商品名称长度，在与价格和数量同行的时候
     * @param count         数量
     * @param price         价格
     * @param maxLine       最大行号
     * @param list          结果接收
     * @return
     */
    public List<String> getDistributionProductLines(String produceName, int maxlength, int maxNameLength, int count, double price, int maxLine, List<String> list) {
        int getlength = getlength(produceName);
        if (getlength > maxNameLength) {
            if (getlength > maxlength) {
                int lengthIndex = getLengthIndex(produceName, maxlength);
                list.add(produceName.substring(0, lengthIndex));
                String substring = produceName.substring(lengthIndex, produceName.length());
                if (list.size() >= maxLine - 1) {
                    int substringlength = getlength(substring);
                    list.add(addDistributionSpaceLine(maxlength, maxNameLength, substring, substringlength, count, price));
                } else {
                    getDistributionProductLines(substring, maxlength, maxNameLength, count, price, maxLine, list);
                }
            } else {
                list.add(produceName);
                list.add(addDistributionSpaceLine(maxlength, maxNameLength, null, 0, count, price));
            }
        } else {
            list.add(addDistributionSpaceLine(maxlength, maxNameLength, produceName, getlength, count, price));
        }
        return list;
    }


    /**
     * 获取居中
     *
     * @param str
     * @param maxSpace
     * @return
     */
    public String getCenterLine(String str, int maxSpace) {
        int strLength = getlength(str);
        int space = maxSpace - strLength;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < space / 2; i++) {
            builder.append(" ");
        }
        builder.append(str);
        return builder.toString();
    }

    /**
     * 获取头和尾部拼接
     *
     * @param startStr
     * @param endStr
     * @param maxLength
     * @return
     */
    public String getSingleLine(String startStr, String endStr, int maxLength) {
        int startStrLength = getlength(startStr.trim());
        int endStrLength = getlength(endStr.trim());
        int spaceLength = maxLength - startStrLength - endStrLength;
        StringBuilder builder = new StringBuilder();
        builder.append(startStr);
        for (int i = 0; i < spaceLength; i++) {
            builder.append(" ");
        }
        builder.append(endStr);
        return builder.toString();
    }

    /**
     * 获取头和尾部拼接
     *
     * @param startStr
     * @param endStr
     * @param maxLength
     * @param maxLine
     * @return
     */
    public List<String> getMoreLine(String startStr, String endStr, int maxLength, int maxLine, List<String> list) {
        int startStrLength = getlength(startStr.trim());
        int endStrLength = getlength(endStr.trim());
        if (startStrLength >= (maxLength - endStrLength)) {
            String titleLine = getTitleLine(maxLine, maxLength, endStrLength, startStr, list);
            if (titleLine == null) return list;
            int titlelength = getlength(titleLine);
            if (titlelength >= (maxLength - endStrLength)) {
                int lengthIndex = getLengthIndex(titleLine, (maxLength - endStrLength) - 3);
                list.add(getSingleLine(titleLine.substring(0, lengthIndex) + "...", endStr, maxLength));
            } else {
                list.add(getSingleLine(titleLine, endStr, maxLength));
            }
        } else {
            list.add(getSingleLine(startStr, endStr, maxLength));
        }
//        LogUtilsLib.d(" " + startStrLength + " " + endStrLength + " :" + maxLine + ":" + builder.toString());
        return list;
    }

    private String getTitleLine(int maxLine, int maxLength, int spaceLength, String str, List<String> result) {
        int getlength = getlength(str);
        if (getlength >= (maxLength - spaceLength)) {
            if (result.size()>= maxLine - 1 ) {
                return str;
            } else {
                int lengthIndex = getLengthIndex(str, maxLength);
                result.add(str.substring(0, lengthIndex));
                String substring = str.substring(lengthIndex, str.length());
                return getTitleLine(maxLine, maxLength, spaceLength, substring, result);
            }
        } else {
            result.add(str);
            return null;
        }
    }

    //27，14,X1000,5,1000, 1000.33
    private String addDistributionSpaceLine(int maxLength, int maxNameLength, String name, int namelength, int count, double price) {
        String countStr = "X" + String.valueOf(count);
        String priceStr = String.format("¥%.2f", price);
        StringBuilder builder = new StringBuilder();
        if (!isEmpty(name)) {
            if (namelength > maxNameLength) {
                int lengthIndex = getLengthIndex(name, maxNameLength - 4);
                builder.append(name.substring(0, lengthIndex));
                builder.append("...");
                namelength = maxNameLength - 1;
            } else {
                builder.append(name);
            }
        }
        int nameSpace = maxNameLength - namelength;
        int priceSpace = maxLength - maxNameLength - countStr.length() - priceStr.length() - 1;
//        int priceSpace = maxLength - maxNameLength - countStr.length() - 7;
        if (priceSpace < 0) {
            nameSpace = nameSpace + priceSpace;
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

    private String addRefundSpaceLine(int maxLength, int maxNameLength, String name, int namelength, double price1, int count, double price2) {
        String price1Str = String.format("¥%.2f", price1);
        String countStr = "x" + String.valueOf(count);
        String price2Str = String.format("¥%.2f", price2);
        StringBuilder builder = new StringBuilder();
        if (!isEmpty(name)) {
            if (namelength > 5) {
                int lengthIndex = getLengthIndex(name, 3);
                String substring = name.substring(0, lengthIndex) + "..";
                builder.append(substring);
                namelength = getlength(substring);
            } else {
                builder.append(name);
                namelength = getlength(name);
            }
        }
        int nameSpace = maxNameLength - namelength - 1;
        for (int i = 0; i < nameSpace; i++) {
            builder.append(" ");
        }
        builder.append(price1Str);
        int price1SpaceCount = 8 - price1Str.length();
        for (int i = 0; i < price1SpaceCount; i++) {
            builder.append(" ");
        }

        builder.append(countStr);
        int countStrSpaceCount = 5 - countStr.length();
        for (int i = 0; i < countStrSpaceCount; i++) {
            builder.append(" ");
        }
        builder.append(price2Str);
        int price2SpaceCount = 7 - price2Str.length();
        for (int i = 0; i < price2SpaceCount; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    private int getlength(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isDouble(str.charAt(i))) {
                sum = sum + 2;
            } else {
                sum = sum + 1;
            }
        }
        return sum;
    }

    private int getLengthIndex(String str, int maxLength) {
        int index = 0;
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (sum == (maxLength - 1)) {
                if (isDouble(ch)) {
                    index = i;
                } else {
                    index = i + 1;
                }
                break;
            } else if (sum == maxLength) {
                index = i;
                break;
            }
            if (isDouble(ch)) sum = sum + 2;
            else sum = sum + 1;
        }
        return index;
    }


    private static boolean isDbcCase(char c) {
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


    private boolean isDouble(char ch) {
        if (!isDbcCase(ch)) {
            return true;
        }
        int n = (int) ch;
        if (!(19968 <= n && n < 40869)) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static String getUserName(String userName) {
        if (isEmpty(userName)) return userName;
        if (userName.length() == 2) {
            return userName.substring(0, 1) + "*";
        } else if (userName.length() == 3) {
            return userName.substring(0, 1) + "**";
        } else if (userName.length() > 3) {
            return userName.substring(0, 2) + "**";
        } else {
            return userName;
        }
    }

    public static void main(String args[]) {
//        testDistrbution();
//        testRefund();
//        testGetLength();
        testMoreLine();
    }

    public static void testMoreLine() {
        List<String> list = new ArrayList<>();
        PrintLineHelper instance = PrintLineHelper.getInstance();
        instance.getMoreLine("[你好吗",
                "-33", 27, 1, list);
        for (String string : list) {
            System.out.println(string + ":" + instance.getlength(string));
        }

    }

    public static void testGetLength() {
        List<String> list = new ArrayList<>();
        list.add("[水果]在有果]在有些情况况e有eee");
        list.add("[你好吗不重复的字体k你懂s去底好吗不重复的字体k你懂去底");
        list.add("[你好吗不重复s的字体k你懂去底好吗不重复的字体k你懂去底");
        list.add("[你好吗不e重复的w字体k你懂去底好吗不重复的字体k你懂去底");
        list.add("[你好吗不e重复的w字体k你懂去底好吗不重复的字体k你懂去底");
        list.add("[你好吗不e重ss复的w字体k你懂去底好吗不重复的字体k你懂去底");
        list.add("[你好吗不e重ss复的w字体k你h懂去底好吗不重复的字体k你懂去底");
        list.add("[你好吗不e重ss3s复的w字体k5你sd懂去底好吗不重复的字体k你懂去底");
        PrintLineHelper instance = PrintLineHelper.getInstance();
        for (String str : list) {
            int lengthIndex = instance.getLengthIndex(str, 27);
            String result = str.substring(0, lengthIndex);
            System.out.println(result + ":" + instance.getlength(result));

        }
    }

    public static void testRefund() {
        PrintLineHelper instance = PrintLineHelper.getInstance();
        ArrayList<String> arrayList = new ArrayList<>();
        instance.getRefundProductLines("[水果]在有果]在有些情况况e有e2",
                435.32, 333, 5.32, 27,
                6,
                5, arrayList);
        for (String string : arrayList) {
            System.out.println(string + ":" + instance.getlength(string));
        }
    }

    public static void testDistrbution() {
        PrintLineHelper instance = PrintLineHelper.getInstance();
        ArrayList<String> arrayList = new ArrayList<>();
        instance.getDistributionProductLines("[水果]在有些情况下有很多长3很长，变态长的商品名，还有特殊符号。长的超乎你的想象[水果]在有些情况下有很多长3很长，变态长的商品名，还有特殊符号。长的超乎你的想象[水果]在有些情况下有很多长3很长商品名，还有特殊符号。长的超乎你的想象[水果]在商品名，还有特殊符号。长的超乎你的想象[水果]在，变态长的商品名，还有特殊符号。长的超乎你的想象[水果]在有些情况下有很多长3很长，变态长的商品名，还有特殊符号。长的超乎你的想象", 27,
                14, 333, 435.32,
                5, arrayList);
        for (String string : arrayList) {
            System.out.println(string + ":" + instance.getlength(string));
        }
    }

}
