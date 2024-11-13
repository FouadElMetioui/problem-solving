package com.letcode.java.medium;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int produit = 1;
        int nbrZero = 0;
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);

        // produit des elements non null
        for (int num : nums)
            if (num != 0)
                produit *= num;
            else {
                nbrZero++;
            }
        // si le tableau contient plus qu'un zero return 0
        if(nbrZero >= 2) {
             Arrays.fill(output,0);
             return output;
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && output[i] != 0) {
                Arrays.fill(output, 0);
                output[i] = produit;
            } else if (output[i] != 0) {
                output[i] = produit / nums[i];
            }
        }


        return output;
    }


}
