package com.wisn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Wisn on 2018/5/30 下午5:44.
 */
public class ThreadPoolManager {
    private ExecutorService service;
    private final SerialExecutor serialExecutor;

    private ThreadPoolManager() {
        int num = Runtime.getRuntime().availableProcessors() * 20;
        service = Executors.newFixedThreadPool(num);
        serialExecutor = new SerialExecutor(service);
    }

    private static final ThreadPoolManager manager = new ThreadPoolManager();

    public static ThreadPoolManager getInstance() {
        return manager;
    }

    public void executeTask(Runnable runnable, boolean isSequentialExecution) {
        if (isSequentialExecution) {
            serialExecutor.execute(runnable);
        } else {
            service.execute(runnable);
        }
    }

    public void executeTask(Runnable runnable) {
        executeTask(runnable, false);
    }

    public void executeTasks(ArrayList<Runnable> list, boolean isSequentialExecution) {
        for (Runnable runnable : list) {
            executeTask(runnable, isSequentialExecution);
        }
    }
}
