package com.letcode.java;
import java.util.HashSet;
import java.util.Set;

public class DuplicateInteger {

    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0 ; i < nums.length ; i ++)
            set.add(nums[i]);

        return !(nums.length == set.size());
    }


    public static void main(String[] args) {
        int [] nums = new int[] {1,4,2,3};
        System.out.println(hasDuplicate(nums));
    }
}
