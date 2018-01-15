package com.wisn.test;

import com.wisn.protocol.core.scanner.Invoker;
import com.wisn.protocol.core.scanner.InvokerHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args){
        System.out.println("time:"+System.currentTimeMillis());
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        Invoker invoker = InvokerHolder.getInvoker((short) 2, (short) 1);
        if(invoker!=null){
            invoker.invoke(null);
        }else{
            System.out.println( "invoker is null");
        }

    }
}
