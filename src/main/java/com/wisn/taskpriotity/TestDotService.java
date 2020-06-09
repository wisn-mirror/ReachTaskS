package com.wisn.taskpriotity;

public class TestDotService {
    public static void main(String arg[]){
        TaskQueue taskQueue = new TaskQueue(8);
        taskQueue.add(new DotTask(110));
        taskQueue.add(new DotTask(112));
        taskQueue.add(new DotTask(1223));
        taskQueue.add(new DotTask(1242));
        taskQueue.add(new DotTask(12662));
        taskQueue.add(new DotTask(127782));

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
