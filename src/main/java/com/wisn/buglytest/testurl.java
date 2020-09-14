package com.wisn.buglytest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class testurl {

    public static void main(String[] arg) {
//            String reg = "(mp4|flv|avi|rm|rmvb|wmv)";
            String reg = "^htt?:\\/\\/(.+\\/)+.+(\\.(swf|avi|flv|mpg|rm|mov|wav|asf|3gp|mkv|rmvb|mp4))";
            String url="ht://cdn.oudianyun.com/lyf/prod/ad-whale/1594793955977_688_dghrzzGC0Z.mp4";
            Pattern p = Pattern.compile(reg);
            boolean boo = p.matcher( url).find();

//        System.out.println(boo);
        System.out.println(Pattern.matches(reg, url));


//        System.out.println(Long.parseLong("#FFFFFF".substring(1), 16)) ;
//        int a=256;
//
////        byte b= (byte) a;
//        int c = get(a);
//        System.out.println(c);
//        System.out.println(a);
       /* String url=" https://api.laiyifen.com/api/realTime/getPriceStockList?mpIds=1007061100000004&areaCode=310117&companyId=30&clientVersion=7.1.20&sessionId=869033028810480&ut=f6aeec192425d02cf3c835299a50409d28&platformId=0&platform=3";
//        String url=" https://api.laiyifen.com/api/realTime/getPriceStockList";
        String url1=" https://api.laiyifen.com";
        try {
            URL url_=new URL(url);

            System.out.println(url_.getProtocol());
            System.out.println(url_.getFile());
            System.out.println(url_.getPath());
            System.out.println(url_.getHost());
            System.out.println(url_.getPort());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/

    }
    public static  int get(int a){
        return (byte)a;
    }

    private static void test01(String url, String url1) {
        System.out.println(url.replace(url1,""));
        String s = UrlPage(url);
        System.out.println(s);
        System.out.println(TruncateUrlPage(url));
        Map<String, String> stringStringMap = URLRequest(url);
        Iterator<Map.Entry<String, String>> iterator = stringStringMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println("key:"+next.getKey()+" value:"+next.getKey());
        }
    }

    /**
     * 解析出url请求的路径，包括页面
     *
     * @param strURL url地址
     * @return url路径
     */
    public static String UrlPage(String strURL) {
        String strPage = null;
        String[] arrSplit = null;

        strURL = strURL.trim().toLowerCase();

        arrSplit = strURL.split("[?]");
        if (strURL.length() > 0) {
            if (arrSplit.length > 1) {
                if (arrSplit[0] != null) {
                    strPage = arrSplit[0];
                }
            }
        }

        return strPage;


    }

    public static String UrlPage1(String strURL) {
        String[] arrSplit = null;
        arrSplit = strURL.split("[?]");
        if (strURL.length() > 0) {
            if (arrSplit.length > 1) {
                if (arrSplit[0] != null) {
                    return arrSplit[0];
                }
            }
        }
        return strURL;
    }
    /**
     * 去掉url中的路径，留下请求参数部分
     *
     * @param strURL url地址
     * @return url请求参数部分
     */
    private static String TruncateUrlPage(String strURL) {
        String strAllParam = null;
        String[] arrSplit = null;

        strURL = strURL.trim().toLowerCase();

        arrSplit = strURL.split("[?]");
        if (strURL.length() > 1) {
            if (arrSplit.length > 1) {
                if (arrSplit[1] != null) {
                    strAllParam = arrSplit[1];
                }
            }
        }

        return strAllParam;
    }

    /**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     *
     * @param URL url地址
     * @return url请求参数部分
     */
    public static Map<String, String> URLRequest(String URL) {
        Map<String, String> mapRequest = new HashMap<String, String>();

        String[] arrSplit = null;

        String strUrlParam = TruncateUrlPage(URL);
        if (strUrlParam == null) {
            return mapRequest;
        }
        //每个键值为一组 www.2cto.com
        arrSplit = strUrlParam.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");
            //解析出键值
            if (arrSplitEqual.length > 1) {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

            } else {
                if (arrSplitEqual[0] != "") {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }

}
