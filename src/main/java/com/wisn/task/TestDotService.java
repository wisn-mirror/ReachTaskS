package com.wisn.task;

public class TestDotService {
    public static void main(String arg[]){
        TaskQueue taskQueue = new TaskQueue(1);
        taskQueue.start();

        for (int i = 0; i < 10; i++) {
            DotTask task = new DotTask(i);
            taskQueue.add(task);
        }
    }
}
