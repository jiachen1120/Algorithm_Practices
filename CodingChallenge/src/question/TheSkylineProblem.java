package question;

import java.util.*;

public class TheSkylineProblem {

    /**
     * A city's skyline is the outer contour of the silhouette formed by all the 
     * buildings in that city when viewed from a distance. Now suppose you are given 
     * the locations and height of all the buildings, write a program to output the 
     * skyline formed by these buildings collectively.
     * For more details, please refer to: https://leetcode.com/problems/the-skyline-problem/description/
     */
    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, (i,j) -> j - i);
        List<int[]> critical_point = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
        	critical_point.add(new int[] {buildings[i][0], buildings[i][2]});
        	critical_point.add(new int[] {buildings[i][1], -buildings[i][2]});
        }
        Collections.sort(critical_point, (a,b) -> {
        	if (a[0] == b[0]) return b[1] - a[1];
        	else return a[0] - b[0];
        });
        
        int pre = 0;
        int cur = 0;
        for (int i = 0; i < critical_point.size(); i++) {
        	int[] cp = critical_point.get(i);
        	if (cp[1] > 0) {
        		maxHeap.add(cp[1]);
        		cur = maxHeap.peek();
        	} else {
        		maxHeap.remove(-cp[1]);
        		cur = (maxHeap.isEmpty()) ? 0 : maxHeap.peek();
        	}
        	if (cur != pre) {
        		res.add(new int[] {cp[0], cur});
        		pre = cur;
        	}
        }
        return res;
    }

    /**********************************************************************
     *                                                                    *
     * Below are to test your codes. DO NOT LOOK WHEN YOU ARE CODING!     *
     *                                                                    *
     **********************************************************************/

    public static void main(String[] args) {

        test(new int[][] { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } },
                new int[][] { { 2, 10 }, { 3, 15 }, { 7, 12 }, { 12, 0 }, { 15, 10 }, { 20, 8 }, { 24, 0 } });

        test(new int[][] { { 0, 2, 3 }, { 2, 5, 3 } }, new int[][] { { 0, 3 }, { 5, 0 } });

        test(new int[][] { { 0, 5, 10 }, { 5, 10, 5 }, { 10, 15, 5 } }, new int[][] { { 0, 10 }, { 5, 5 }, { 15, 0 } });

        System.out.println("--------------------\nTest DONE");
    }

    private static void test(int[][] buildings, int[][] expected) {
        List<int[]> result = getSkyline(buildings);
        for (int i = 0; i < Math.min(result.size(), expected.length); i++) {
            for (int j = 0; j < 2; j++) {
                if (result.get(i)[j] != expected[i][j]) {
                    System.out.println("\n[TEST FAILED]\nInput:" + arrayToString(buildings) + "\nExpected :"
                            + arrayToString(expected) + "\nActual: " + arrayToString(result));
                    return;
                }
            }
        }
    }

    private static String arrayToString(int[][] array) {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int[] row : array) {
            builder.append(Arrays.toString(row));
            builder.append(',');
        }
        builder.setLength(builder.length() - 1);
        builder.append(']');
        return builder.toString();
    }

    private static String arrayToString(List<int[]> list) {
        int[][] array = new int[list.size()][list.get(0).length];
        array = list.toArray(array);
        return arrayToString(array);
    }
}