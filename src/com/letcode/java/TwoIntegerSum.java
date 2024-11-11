package com.letcode.java;

import java.util.Arrays;

public class TwoIntegerSum {
    public static void main(String[] args) {
        int [] nums = new int[] {3,4,5,6};
        int target =  7;
        assert Arrays.equals((twoSum(nums, target)) , new int[] {0,1});
    }

    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        for (int i = nums.length-1 ; i >= 0 ; i--) {
            for (int j = 0 ; j< i ; j++) {
                if (nums[i] + nums[j] == target){
                    result[0] = j;
                    result[1] = i;
                    return result;
                }
            }
        }
        return result;
    }
}
