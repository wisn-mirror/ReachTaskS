package com.wisn.buglytest;
import com.google.gson.Gson;
import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BuglyData {
//    public static final String number = "(\\d+)(x|X)(\\d+)";
    public static final String number = "^[0-9]*$";

    public static void main(String arg[]) {
        System.out.println("4321432".matches(number));
        System.out.println("5324321".matches(number));
        System.out.println("33n".matches(number));
        System.out.println("汉子".matches(number));

    }

    public static void excuteExcelData(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/mac/IdeaProjects/ReachTaskS/src/buglyData.json"));
            TreeMap<Double,Long> resutl=new TreeMap<Double,Long>(new Comparator<Double>(){


                @Override
                public int compare(Double o1, Double o2) {
                    if(o1.doubleValue()==o2.doubleValue()){
                        return 0;
                    }else{
                        return o1.doubleValue()>o2.doubleValue()?1:-1;

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
                    if(aLong==null){
                        resutl.put(next.version,next.value);
                    }else{
                        resutl.replace(next.version,aLong+next.value);
                    }
                }
            }
            br.close();
            Iterator<Map.Entry<Double, Long>> iterator1 = resutl.entrySet().iterator();
            while (iterator1.hasNext()){
                Map.Entry<Double, Long> next = iterator1.next();
                String result = next.getKey() + " " + next.getValue();

                System.out.println(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getBugly(){
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
