package com.yumtao.review;

import java.util.concurrent.*;

public class ExecutorTest {

    /**
     * 线程池配置参数：corePoolSize：核心线程数；maximumPoolSize：最大线程数；keepAliveTime：最大空闲时间；任务队列size
     * 执行顺序：
     * 1.判断当前核心线程数是否达到核心线程数配置，未达到new Thread
     * 2.达到判断任务队列size是否超出，没有超出放入队列中等待执行
     * 3.超出判断线程数是否达到最大线程数配置，没有new Thread
     * 4.达到最大线程数配置 报错
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        singleThread();
        blockQueue();
    }

    private static void blockQueue() {

        ExecutorService executorService = new ThreadPoolExecutor(1, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": AAAAAA");
            } catch (InterruptedException e) {
                System.err.println("sleep error");
            }
        });
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ": BBBBBB");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("sleep error");
            }
        });
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ": CCCCC");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("sleep error");
            }
        });
    }

    private static void singleThread() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": aaaaaa");
            } catch (InterruptedException e) {
                System.err.println("sleep error");
            }
        });
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ": bbbbbb");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("sleep error");
            }
        });
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ": ccccc");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("sleep error");
            }
        });
    }
}
