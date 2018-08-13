package question;

import java.util.Arrays;

public class RemoveAllDuplicatesFromSortedArray {

    /**
     * Given a sorted array nums, remove the duplicates in-place such that each 
     * element appear only once and return the new length. Do not allocate extra 
     * space for another array, you must do this by modifying the input array in-place 
     * with O(1) extra memory.
     */
    public static int[] removeDuplicates(int[] nums) {
    	if (nums == null) return new int[] {};
    	if (nums.length <= 0) return nums;
    	
    	Arrays.sort(nums);
    	int cur = nums[0];
    	int j = 1;
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i] != cur) {
    			cur = nums[i];
    			nums[j] = cur;
    			j++;
    		}
    	}
        return Arrays.copyOfRange(nums, 0, j);
    }

    /**********************************************************************
     *                                                                    *
     * Below are to test your codes. DO NOT LOOK WHEN YOU ARE CODING!     *
     *                                                                    *
     **********************************************************************/

    public static void main(String[] args) {
        happyCase1();
        happyCase2();
        happyCase3();
        happyCase4();
        happyCase5();
        happyCase6();
        happyCase7();
        happyCase8();
        System.out.println("--------------------\nTest DONE");
    }

    private static boolean happyCase1() {
        int[] testData = new int[] { 1, 2, 2, 3 };
        int[] expectedResult = new int[] { 1, 2, 3 };
        int[] actualResult = removeDuplicates(testData);
        for (int i = 0; i < expectedResult.length; i++) {
            if (expectedResult[i] != actualResult[i]) {
                System.out.println("expect output is [1,2,3] but actual output is " + Arrays.toString(actualResult));
                return false;
            }
        }
        return true;
    }

    private static boolean happyCase2() {
        int[] testData = new int[] { 1, 2, 2, 2, 3 };
        int[] expectedResult = new int[] { 1, 2, 3 };
        int[] actualResult = removeDuplicates(testData);
        for (int i = 0; i < expectedResult.length; i++) {
            if (expectedResult[i] != actualResult[i]) {
                System.out.println("expect output is [1,2,2,3] but actual output is " + Arrays.toString(actualResult));
                return false;
            }
        }
        return true;
    }

    private static boolean happyCase3() {
        int[] testData = new int[] { 1, 2, 2, 3, 3 };
        int[] expectedResult = new int[] { 1, 2, 3 };
        int[] actualResult = removeDuplicates(testData);
        for (int i = 0; i < expectedResult.length; i++) {
            if (expectedResult[i] != actualResult[i]) {
                System.out.println("expect output is [1,2,3] but actual output is " + Arrays.toString(actualResult));
                return false;
            }
        }
        return true;
    }

    private static boolean happyCase4() {
        int[] testData = new int[] {};
        int[] actualResult = removeDuplicates(testData);
        if (actualResult.length != 0) {
            System.out.println("expect output is [] but actual output is " + Arrays.toString(actualResult));
            return false;
        }
        return true;
    }

    private static boolean happyCase5() {
        int[] expectedResult = new int[] { 1 };
        int[] actualResult = removeDuplicates(expectedResult);
        if (actualResult.length != 1 || actualResult[0] != 1) {
            System.out.println("expect output is [1] but actual output is " + Arrays.toString(actualResult));
            return false;
        }
        return true;
    }

    private static boolean happyCase6() {
        int[] testData = new int[] { 1, 1 };
        int[] expectedResult = new int[] { 1 };
        int[] actualResult = removeDuplicates(testData);
        for (int i = 0; i < expectedResult.length; i++) {
            if (expectedResult[i] != actualResult[i]) {
                System.out.println("expect output is [1] but actual output is " + Arrays.toString(actualResult));
                return false;
            }
        }
        return true;
    }

    private static boolean happyCase7() {
        int[] testData = new int[] { 1, 2, 3 };
        int[] expectedResult = new int[] { 1, 2, 3 };
        int[] actualResult = removeDuplicates(testData);
        for (int i = 0; i < expectedResult.length; i++) {
            if (expectedResult[i] != actualResult[i]) {
                System.out.println("expect output is [1,2,3] but actual output is " + Arrays.toString(actualResult));
                return false;
            }
        }
        return true;
    }

    private static boolean happyCase8() {
        int[] expectedResult = null;
        int[] actualResult = removeDuplicates(expectedResult);
        if (actualResult == null) {
            System.out.println("expect output is [] but actual output is null");
            return false;
        }
        if (actualResult.length != 0) {
            System.out.println("expect output is [] but actual output is " + Arrays.toString(actualResult));
            return false;
        }
        return true;
    }
}