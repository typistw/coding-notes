package com.leetcode.easy;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int[] nums2 = {7,6,4,3,1};
        int[] nums3 = {};

        System.out.println(maxProfit(nums));
        System.out.println(maxProfit(nums2));
        System.out.println(maxProfit(nums3));
    }

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;

        int mintPrice = prices[0];
        int maxProfit = 0, sumProfit = 0;
        for(int i = 1; i < prices.length; i++){
            int val = prices[i];
            if(val < mintPrice){
                mintPrice = val;
                sumProfit +=  maxProfit;
                maxProfit = 0;
                continue;
            }

            int profit = val - mintPrice;
            if(maxProfit == 0){
                maxProfit = profit;
                continue;
            }

            if(profit < maxProfit){
                sumProfit += maxProfit;
                mintPrice = val;
                maxProfit = 0;
            }else{
                maxProfit = profit;
            }
        }

        sumProfit += maxProfit;

        return  sumProfit;
    }
}
