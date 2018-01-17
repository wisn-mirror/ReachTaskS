package com.wisn.test;

import com.wisn.protocol.core.scanner.Invoker;
import com.wisn.protocol.core.scanner.InvokerHolder;
import com.wisn.tools.DateUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.UUID;

public class Test {
    public static void main(String[] args){
        /*System.out.println("time:"+System.currentTimeMillis());
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        Invoker invoker = InvokerHolder.getInvoker((short) 2, (short) 1);
        if(invoker!=null){
            invoker.invoke(null);
        }else{
            System.out.println( "invoker is null");
        }*/
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID().toString().length());
        Date dateAfterHours = DateUtils.getDateAfterHours(new Date(), 8);
        System.out.println(dateAfterHours.getTime());
        System.out.println(new Date().getTime());
        System.out.println(dateAfterHours.getTime()-new Date().getTime());
        System.out.println(8*3600);


    }
}
