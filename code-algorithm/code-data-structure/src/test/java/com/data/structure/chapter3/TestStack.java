package com.data.structure.chapter3;

import org.junit.Assert;
import org.junit.Test;

/*
 * @author：jinsheng
 * @date：2020/04/12 10:55
 */
public class TestStack {

    @Test
    public void testBalanceSymbol(){
        String s = "a+b*(4+5)/7";
        String s2 = "a+b*[4+5]/7";
        String s3 = "[a+b*(4+5)/7]*5";
        String s4 = "[a+b*(4+5)+7*5";
        String s5 = "[a+b*(4+5/7]*5";
        String s6 = "a+b*(4+5)/7]*5";
        String s7 = "[a+b*4+5)/7]*5";
        String s8 = "a+b*4+5)/7]*5";

        Assert.assertTrue(StackExample.checkBalanceSymbol(s));
        Assert.assertTrue(StackExample.checkBalanceSymbol(s2));
        Assert.assertTrue(StackExample.checkBalanceSymbol(s3));
        Assert.assertFalse(StackExample.checkBalanceSymbol(s4));
        Assert.assertFalse(StackExample.checkBalanceSymbol(s5));
        Assert.assertFalse(StackExample.checkBalanceSymbol(s6));
        Assert.assertFalse(StackExample.checkBalanceSymbol(s7));
        Assert.assertFalse(StackExample.checkBalanceSymbol(s8));
    }

    @Test
    public void testInfixToPostfix(){
        String s = "a+b*c+(d*e+f)*g";
        System.out.println(s + " convert to: " + StackExample.infixToPostfix(s));
    }

    @Test
    public void testPostfixCalculating(){
        String s = "6523+8*+3+*";
        System.out.println(StackExample.postfixCalculating(s));
    }
}
