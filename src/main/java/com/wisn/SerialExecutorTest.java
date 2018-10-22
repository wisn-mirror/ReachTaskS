package com.wisn;

public class SerialExecutorTest {

    public static void main(String[] arg){

        EvnConstants.updateEvn(EvnConstants._edu);
        System.out.println(EvnConstants.CurrentEvn.BASEURL);
//        boolean before = DateUtils.isBefore(DateUtils.getCaleadarBeforDay(7),Calendar.getInstance());
//        Calendar instance = Calendar.getInstance();
//        instance .setTimeInMillis(1536290219000l);
//        Date dateByStr = DateUtils.getDateByStr("2018-08-01 13:33:23", "yyyy-MM-dd HH:mm:ss");
//        Date dateByStr = DateUtils.getDateByStr("2018-08-31 12:38:00", "yyyy-MM-dd HH:mm:ss");
//        instance.setTime(dateByStr);
//        boolean before = DateUtils.isBefore(DateUtils.getCaleadarBeforDay(7,false),instance);
//        System.out.println(before);
      /*  ArrayList<Runnable> runnables=new ArrayList<>();

        runnables.add(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<10;i++){
                    System.out.println("BBB"+i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        runnables.add(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<10;i++){
                    System.out.println("CCC"+i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        runnables.add(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<10;i++){
                    System.out.println("DDD"+i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        runnables.add(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<10;i++){
                    System.out.println("EEE"+i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        runnables.add(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<10;i++){
                    System.out.println("AAA"+i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        ThreadPoolManager.getInstance().executeTasks(runnables,true);
        */

    }
}
