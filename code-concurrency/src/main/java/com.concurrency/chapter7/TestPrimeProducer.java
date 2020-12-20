package com.concurrency.chapter7;

import com.alibaba.fastjson.JSON;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * @author：jinsheng
 */
public class TestPrimeProducer {

    public static void main(String[] args) {
        BlockingQueue<BigInteger> queue = new LinkedBlockingQueue<>();
        PrimeProducer producer = new PrimeProducer(queue);
        producer.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            producer.cancel();
        }

        System.out.println(JSON.toJSONString(queue));
    }
}
