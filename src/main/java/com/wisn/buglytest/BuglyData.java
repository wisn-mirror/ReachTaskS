package com.wisn.buglytest;
import com.google.gson.Gson;
import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

public class BuglyData {
    public static void main(String arg[]) {
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
