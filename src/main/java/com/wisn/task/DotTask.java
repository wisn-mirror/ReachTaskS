package com.wisn.task;

public class DotTask implements ITask {

    private int id;

    public DotTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }

        System.out.println("我的id是：" + id);
    }
}
