package com.wisn.taskpriotity;

public class DotTask extends BasicTask {

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
