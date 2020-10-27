package com.leetcode.easy;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))
 *
 *
 * Example 1:
 *
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 *
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * At most 104 calls will be made to sumRange.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class RangeSumQuery {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));

        NumArray2 numArray2 = new NumArray2(nums);
        System.out.println(numArray2.sumRange(0, 2));
        System.out.println(numArray2.sumRange(2, 5));
        System.out.println(numArray2.sumRange(0, 5));
    }

    static class NumArray {

        private int[] nums;
        public NumArray(int[] nums) {
            this.nums = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                this.nums[i] = nums[i];
            }
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for(int n = i; n <= j; n++){
                sum += this.nums[n];
            }
            return sum;
        }
    }

    static class NumArray2 {

        private int[] sums;
        public NumArray2(int[] nums) {
            sums = new int[nums.length + 1];
            for(int i = 0; i < nums.length; i++){
                sums[i + 1] = nums[i] + sums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }
}
