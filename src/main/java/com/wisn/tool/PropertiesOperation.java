package com.wisn.tool;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

public class PropertiesOperation {

    Properties prop = new Properties();

    public PropertiesOperation(String path) {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(path));
            prop.load(in);     ///加载属性列表
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void addProperties(String path, String key, String value) {
        try {
            FileOutputStream oFile = new FileOutputStream(path, false);//true表示追加打开
            prop.setProperty(key, value);
            prop.store(oFile, "The New properties file");
            oFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return prop;
    }

    public void printProperties() {
        System.out.println("===============");
        Iterator<String> it = prop.stringPropertyNames().iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + ":" + prop.getProperty(key));
        }
        System.out.println("===============");
    }
}
