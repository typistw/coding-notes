package com.concurrency.chapter8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * @author：jinsheng
 */
public class MyAppThread extends Thread{

    public static final String DEFAULT_NAME = "myAppThread";

    private static volatile boolean debugLifecycle = false;
    private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    private static final Logger log = LoggerFactory.getLogger(MyAppThread.class);

    public MyAppThread(Runnable r){
        this(r, DEFAULT_NAME);
    }

    public MyAppThread(Runnable r, String name){
        super(r, name + '-' + created.incrementAndGet());
        setUncaughtExceptionHandler(
//                new Thread.UncaughtExceptionHandler(){
//                    @Override
//                    public void uncaughtException(Thread t, Throwable e) {
//                        log.warn("uncaught in thread {}" , t.getName(), e);
//                    }
//                }

            (Thread t, Throwable e) -> {
                log.warn("uncaught in thread {}" , t.getName(), e);
            }
        );
    }

    public void run(){
        boolean debug = debugLifecycle;
        if(debug){
            log.info("created {}",getName());
        }

        try {
            alive.incrementAndGet();
            super.run();
        }finally {
            alive.decrementAndGet();
            if(debug){
                log.info("exiting ", getName());
            }
        }
    }

    public static int getThreadsCreated(){
        return created.get();
    }

    public static int getThreadsAlive(){
        return alive.get();
    }

    public static boolean getDebug(){
        return debugLifecycle;
    }

    public static void setDebug(boolean b){
        debugLifecycle = b;
    }
}
