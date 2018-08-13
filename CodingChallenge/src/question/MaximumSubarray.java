package question;

import java.util.Arrays;
import java.util.Random;

public class MaximumSubarray {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) 
     * which has the largest sum and return its sum.
     * 
     * Example:Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     */
    public static int maxSubArray(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
    	if (nums.length == 1) return nums[0];
        //Write your code here
    	int[] dp = new int[nums.length];
    	dp[0] = nums[0];
    	int max = Integer.MIN_VALUE;
    	for (int i = 1; i < nums.length; i++) {
    		dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
    		max = Math.max(dp[i], max);
    	}
        return max;
    }
    
    /**********************************************************************
     *                                                                    *
     * Below are to test your codes. DO NOT LOOK WHEN YOU ARE CODING!     *
     *                                                                    *
     **********************************************************************/
    
    private static final int NUM_TESTS = 10;
    private static final int MAXIMUM_ARRAY_LENGTH = 20;
    private static final int NUMBER_BOUND = 100;

    public static void main(String[] args) {
        test(null);
        test(new int[0]);
        test(new int[]{0});
        test(new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3});
        Random random = new Random();
        for (int i=0; i<NUM_TESTS; i++) {
            int l = random.nextInt(MAXIMUM_ARRAY_LENGTH);
            int[] input = new int[l];
            int sign = random.nextBoolean() ? 1 : -1;
            for (; i<l; i++) input[i] = sign*random.nextInt(NUMBER_BOUND);
            test(input);
        }
        System.out.println("--------------------\nTest DONE");
    }

    private static void test(int[] input) {
        int expected = maxSubArrayGolden(input);
        int actual = MaximumSubarray.maxSubArray(input);
        if (actual != expected) {
            System.out.println("\n[TEST FAILED]\nInput:"+ Arrays.toString(input) + "\nExpected :" + expected + "\nActual: " + actual);
        }
    }


    private static int maxSubArrayGolden(int[] nums) {
        //O(n) time with O(1) space
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //in case the result is negative.
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num: nums) {
            sum += num;
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }
        return max;
    }

}

