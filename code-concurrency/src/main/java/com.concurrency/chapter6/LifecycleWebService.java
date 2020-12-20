package com.concurrency.chapter6;

import sun.misc.Request;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/*
 * @author：jinsheng
 */
public class LifecycleWebService {
    private static final int NTHREADS = 100;
    private static final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public  void start () throws IOException{
        ServerSocket socket =  new ServerSocket(80);
        while (true){
            try {
                final Socket connection = socket.accept();
                Runnable task = ()-> {
                    handleRequest(connection);
                };
                exec.execute(task);
            } catch (RejectedExecutionException e) {
                if(!exec.isShutdown()){
                    System.out.println("task submission rejected:" + e);
                }
            }

        }
    }

    public void stop(){
        exec.shutdown();
    }

    private void handleRequest(Socket socket){
        Request request = readRequest(socket);
        if(isShutDownRequest(request)){
            stop();
        }else {
            dispatchRequest(request);
        }
    }

    private Request readRequest(Socket socket){
        return new Request() {
            @Override
            public void execute() {

            }
        };
    }

    private boolean isShutDownRequest(Request request){
        return true;
    }

    private void dispatchRequest(Request request){

    }
}
