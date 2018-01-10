package com.wisn.protocol.core.scanner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class InvokerHolder {
    public static HashMap<Short, HashMap<Short, Invoker>> invokers = new LinkedHashMap<>();

    public static void addInvoker(short module, short cmd, Invoker invoker) {
        HashMap<Short, Invoker> shortInvokerHashMap = invokers.get(module);
        if (shortInvokerHashMap == null) {
            shortInvokerHashMap = new HashMap<>();
            shortInvokerHashMap.put(cmd,invoker);
            invokers.put(module,shortInvokerHashMap);
        }
        shortInvokerHashMap.put(cmd, invoker);
    }

    public static Invoker getInvoker(short module, short cmd) {
        print();
        HashMap<Short, Invoker> shortInvokerHashMap = invokers.get(module);
        if (shortInvokerHashMap == null) return null;
        return shortInvokerHashMap.get(cmd);
    }
    public static void print(){
        Iterator<Map.Entry<Short, HashMap<Short, Invoker>>> iterator = invokers.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Short, HashMap<Short, Invoker>> next = iterator.next();
            if(next==null)continue;
            Short key = next.getKey();
            System.out.println("module:"+key);
            HashMap<Short, Invoker> value = next.getValue();
            Iterator<Map.Entry<Short, Invoker>> iterator1 = value.entrySet().iterator();
            while (iterator1.hasNext()){
                Map.Entry<Short, Invoker> next1 = iterator1.next();
                if(next1==null)continue;
                System.out.println("cmd:"+next1.getKey()+" invoker:"+next1.getValue().toString());
            }
        }
    }

}
