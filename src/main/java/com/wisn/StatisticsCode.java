package com.wisn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class StatisticsCode {
    public long sum;
    public long Filecount;
    public List<String> filetype;


    public static void main(String[] arg){
        StatisticsCode StatisticsCode=new StatisticsCode();
        StatisticsCode.dealFile(new File("/Users/mac/Desktop/backup/Android_lyf_mall1"));
        StatisticsCode.result();
    }
    public void dealFile(File file ){
        if(file==null){
            return ;
        }
        if(file.isDirectory()){
           File[] files = file.listFiles();
           if(files!=null){
              for(File fileone:files){
                  dealFile(fileone);
              }
           }
        }else{
            readFile(file);
        }
    }
    public void readFile(File file){
        try {
//            file.getName().endsWith()
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            long count = br.lines().count();
            sum=sum+count;
            Filecount++;
            System.out.println(file.getAbsoluteFile().getAbsolutePath()+":"+count+"行");
            br.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void result(){
        System.out.println("总共：文件："+Filecount+" 行："+sum);
    }
}
