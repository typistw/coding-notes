package com.leetcode.medium;

/**
 *  int startIdx = 0, tripIdx = -1, gasSum = 0;
 *         for (int i = 0; i < gas.length; i++) {
 *             gasSum += gas[i];
 *
 *             if (gasSum >= cost[i]) {
 *                 gasSum -= cost[i];
 *                 tripIdx = i + 1;
 *                 if (tripIdx == gas.length) {
 *                     tripIdx = 0;
 *                 }
 *             } else {
 *                 i = startIdx;
 *                 startIdx++;
 *                 tripIdx = -1;
 *                 gasSum = 0;
 *             }
 *
 *             if (i + 1 == gas.length && startIdx < gas.length) {
 *                 i = -1;
 *             }
 *
 *             if (startIdx == tripIdx) {
 *                 return startIdx;
 *             }
 *         }
 *
 *         return -1;
 *
 * @Auther: jinsheng.wei
 *
 * @Description:
 */
public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        int[] gas2 = {2, 3, 4}, cost2 = {3, 4, 3};
        int[] gas3 = {5, 1, 2, 3, 4}, cost3 = {4, 4, 1, 5, 1};

        System.out.println(canCompleteCircuit(gas, cost));
        System.out.println(canCompleteCircuit(gas2, cost2));
        System.out.println(canCompleteCircuit(gas3, cost3));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int startIdx = 0, tripIdx = -1, gasSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];

            if (gasSum >= cost[i]) {
                gasSum -= cost[i];
                tripIdx = i + 1;
                if (tripIdx == gas.length) {
                    tripIdx = 0;
                }
            } else {
                i = startIdx;
                startIdx++;
                tripIdx = -1;
                gasSum = 0;
            }

            if (i + 1 == gas.length && startIdx < gas.length) {
                i = -1;
            }

            if (startIdx == tripIdx) {
                return startIdx;
            }
        }

        return -1;
    }
}
