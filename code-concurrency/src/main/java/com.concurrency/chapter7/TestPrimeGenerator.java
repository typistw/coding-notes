package com.concurrency.chapter7;

import com.alibaba.fastjson.JSON;

import java.math.BigInteger;
import java.util.List;

/*
 * @author：jinsheng
 */
public class TestPrimeGenerator {

    public static void main(String[] args) {
        List<BigInteger> list = aSecondOfPrimes();
        System.out.println(JSON.toJSONString(list));
    }

    private static List<BigInteger> aSecondOfPrimes(){
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            generator.cancel();
        }

        return generator.get();
    }

}
