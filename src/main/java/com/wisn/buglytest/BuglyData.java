package com.wisn.buglytest;
import com.google.gson.Gson;
import java.io.*;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BuglyData {

    /**
     * 获取MD5字符串
     *
     * @param s String
     * @return MD5 String
     */
    public static String getMD5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String str = Integer.toHexString(0xFF & aMessageDigest);
                if (str.length() == 1) {
                    hexString.append("0" + str);
                } else {
                    hexString.append(str);
                }
            }
            return hexString.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String md5Digest(String pwd){
        try{
            MessageDigest alg = MessageDigest.getInstance("MD5");
            alg.update(pwd.getBytes("UTF-8"));
            byte[] digest = alg.digest();
            return byte2hex(digest);
        } catch (Exception e) {
            e.getMessage();
            return "";
        }

    }

    private static String byte2hex(byte[] b){
        String hs = "";
        for (int n = 0; n < b.length; n++) {
           String stmp = Integer.toHexString(b[n] & 0xFF);
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
        }
        return hs.toLowerCase();
    }




    //    public static final String number = "(\\d+)(x|X)(\\d+)";
    public   String number = "^[0-9]*$";
    public static long feiboqi(int i){
        if(i<=1){
            return 1;
        }else{
            return feiboqi(i-1)+feiboqi(i-2);
        }
    }
//1572501711684
//1572501782006

    public static void main(String arg[]) {
        System.out.println(getMD5("123456"));
        System.out.println(md5Digest("123456"));
//        long size= 2>>>30;
//        System.out.println("size: "+size);
//        System.out.println("size2: "+1024*1024*1024);
//        System.out.println(System.currentTimeMillis());
       /* int a=1000;
        int b=200;
        System.out.println(a|b);
        System.out.println(a&b);*/
     /*  long result=0;
        System.out.println("start");
        long l = System.currentTimeMillis();
        for(int i=0;i<1935553358l;i++){
           result=result+i;
       }
        System.out.println("end "+result);
        System.out.println("用时毫秒"+(System.currentTimeMillis()-l));
*/



     /*  List<TestBean> da=new ArrayList<>();
        da.add(new TestBean());
        da.add(new TestBean());
        da.add(new TestBean());
        da.add(new TestBean());
        for(TestBean testBean :da){
//            System.out.println(testBean);
            testBean.content="aaa";
        }
        for(TestBean testBean :da){
            System.out.println(testBean);
        }*/

//            String a="0";
//            String b="0";
//        System.out.println(a==b);
//        System.out.println("0".hashCode());
//        System.out.println("0".hashCode());
//        System.out.println("0"=="0");
//        System.out.println("0"==new String("0"));
//        System.out.println(new String("0")==new String("0"));
   /*     HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("dd","44");
        hashMap.put("dd","44");
        hashMap.put("dd","44");
        System.out.println(hashMap.size());*/
    /*    System.out.println("4321432".matches(number));
        System.out.println("5324321".matches(number));
        System.out.println("33n".matches(number));
        System.out.println("汉子".matches(number));*/
//        System.out.println( getCountDown(1000*60*2));
//        System.out.println( getCountDown(1000*60*2+1000*60*60*10));
//        System.out.println( getCountDown(1000*60*2+1000*60*60*100));
//        System.out.println( getCountDownByDay(1000l*60l*2l+1000l*60l*60l*59993l));

//        getBugly2();
       /* String url="https://lyf://index_aaa";
        System.out.println(url.indexOf("lyf://"));
        System.out.println(url.substring(url.indexOf("lyf://"),url.length()));
       url= url.substring(url.indexOf("lyf://"));
        System.out.println(url.substring(url.indexOf("lyf://")));*/
       /* try {
            long str=  System.currentTimeMillis();
            System.out.println("time:"+str);
//            String encrypt = AESUtil.encrypt("00042821" + "#&&#" + str);
            String encrypt = AESUtil.encrypt("00042821" + "#&&#");
            System.out.println("aes:"+encrypt);
            String  encryptc=URLEncoder.encode(encrypt, "utf-8");
            System.out.println("encode:"+encryptc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/

    }

    private static void test01(long l) {
        for(int i=0;i<50;i++){
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI +" "+feiboqi(finalI));
                    System.out.println("用时毫秒"+(System.currentTimeMillis()-l));

                }
            }).start();
        }
    }

    public static class TestBean{
        public String content;

        @Override
        public String toString() {
            return "TestBean{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }


    public static void getBugly2() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/mac/IdeaProjects/ReachTaskS/src/buglyData2.json"));
            Gson gson = new Gson();
            AppHomePageBean dataBean = gson.fromJson(br, AppHomePageBean.class);
            System.out.println(dataBean);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void getBugly3() {
        /*try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/mac/IdeaProjects/ReachTaskS/src/buglyData2.json"));
            br.read();
            JSON.parseArray(,VersionData.class);
            VersionData dataBean = gson.fromJson(br, VersionData.class);
            System.out.println(dataBean);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }


    /**
     * 获取时间（倒计时）
     *
     * @param
     * @return
     */
    public static String getCountDown(long ms) {
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - hour * hh - day * dd) / mi;
        long second = (ms - hour * hh - minute * mi - day * dd) / ss;

        String strday = day < 10 ? "0" + day : "" + day;      //天
        String strHour = hour < 10 ? "0" + hour : "" + hour;//小时
        String strMinute = minute < 10 ? "0" + minute : "" + minute;//分钟
        String strSecond = second < 10 ? "0" + second : "" + second;//秒

        return hour > 0 ? strHour + ":" + strMinute + ":" + strSecond : strMinute + ":" + strSecond;
    }

    /**
     * 获取时间（倒计时）
     *
     * @param
     * @return
     */
    public static String getCountDownByDay(long ms) {
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - hour * hh - day * dd) / mi;
        long second = (ms - hour * hh - minute * mi - day * dd) / ss;

        String strday = day < 10 ? "0" + day : "" + day;      //天
        String strHour = hour < 10 ? "0" + hour : "" + hour;//小时
        String strMinute = minute < 10 ? "0" + minute : "" + minute;//分钟
        String strSecond = second < 10 ? "0" + second : "" + second;//秒
        if (day > 0) {
            return strday + "天" + strHour + "时" + strMinute + "分";
        }
        return strHour + "时" + strMinute + "分" + strSecond + "秒";
    }

    public static void excuteExcelData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/mac/IdeaProjects/ReachTaskS/src/buglyData.json"));
            TreeMap<Double, Long> resutl = new TreeMap<Double, Long>(new Comparator<Double>() {


                @Override
                public int compare(Double o1, Double o2) {
                    if (o1.doubleValue() == o2.doubleValue()) {
                        return 0;
                    } else {
                        return o1.doubleValue() > o2.doubleValue() ? 1 : -1;

                    }
                }

            });
            Gson gson = new Gson();
            VersionData dataBean = gson.fromJson(br, VersionData.class);
            if (dataBean != null) {
                Iterator<VersionData.Data> iterator = dataBean.data.iterator();
                while (iterator.hasNext()) {
                    VersionData.Data next = iterator.next();
                    Long aLong = resutl.get(next.version);
                    if (aLong == null) {
                        resutl.put(next.version, next.value);
                    } else {
                        resutl.replace(next.version, aLong + next.value);
                    }
                }
            }
            br.close();
            Iterator<Map.Entry<Double, Long>> iterator1 = resutl.entrySet().iterator();
            while (iterator1.hasNext()) {
                Map.Entry<Double, Long> next = iterator1.next();
                String result = next.getKey() + " " + next.getValue();

                System.out.println(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getBugly() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/mac/IdeaProjects/ReachTaskS/src/buglyData.json"));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("/Users/mac/IdeaProjects/ReachTaskS/src/data.txt")));
            DecimalFormat formatter = new DecimalFormat();
            formatter.applyPattern("#0.00");//格式代码，".00"代表保留2位小数，是0的输出0
            DateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
            DateFormat formatTo = new SimpleDateFormat("MM月dd日", Locale.getDefault());
            Gson gson = new Gson();
            DataBean dataBean = gson.fromJson(br, DataBean.class);
            if (dataBean != null) {
                Iterator<DataBean.RetBean.Data1Bean> iterator = dataBean.ret.data.iterator();
                while (iterator.hasNext()) {
                    DataBean.RetBean.Data1Bean next = iterator.next();
                    Date parse1 = format.parse(next.date);
                    String format2 = formatTo.format(parse1);
                    String result = format2 + " " + formatter.format((next.crashUser * 100) / next.accessUser);
                    bw.write(result);
                    bw.newLine();
                    System.out.println(result);
                }
            }
            br.close();
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
