package com.wisn.taskpriotity;

public class TestDotService {
    public static void main(String arg[]){
        TaskQueue taskQueue = new TaskQueue(1);
        taskQueue.add(new DotTask(110));
        taskQueue.add(new DotTask(112));
        taskQueue.add(new DotTask(122));

        for (int i = 0; i < 10; i++) {
            DotTask task = new DotTask(i);
            if (1 == i) {
                task.setPriority(Priority.LOW);
            } else if (8 == i) {
                task.setPriority(Priority.HIGH);
            } else if (9 == i) {
                task.setPriority(Priority.Immediately);
            }
            taskQueue.add(task);
        }
        taskQueue.start();

    }
}
