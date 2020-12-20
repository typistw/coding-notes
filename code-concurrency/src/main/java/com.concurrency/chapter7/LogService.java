package com.concurrency.chapter7;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * 向 LogWriter 添加可靠的取消操作
 * @author：jinsheng
 */
public class LogService {
    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;
    private final PrintWriter printWriter;
    private boolean isShutDown;
    private int reservations;

    public LogService(Writer writer){
        queue = new LinkedBlockingQueue<>();
        loggerThread = new LoggerThread();
        printWriter  = new PrintWriter(writer);
    }

    public void start(){
        loggerThread.start();
    }

    public void stop(){
        synchronized (this){
            isShutDown = true;
        }
        loggerThread.interrupt();
    }

    public void log(String msg) throws InterruptedException {
        synchronized (this){
            if(isShutDown){
                throw new IllegalStateException();
            }
             ++ reservations;
        }
        queue.put(msg);
    }


    private class LoggerThread extends Thread{
        public void run(){
            try {
                while (true){
                    try {
                        synchronized (LogService.this){
                            if(isShutDown && reservations == 0)
                                break;
                        }
                        String msg = queue.take();
                        synchronized (LoggerThread.this){
                            -- reservations;
                        }
                        printWriter.println(msg);
                    }catch (Exception e){
                        // retry
                    }
                }
            }finally {
                printWriter.close();
            }
        }
    }

}
