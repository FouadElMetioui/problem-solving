package com.letcode.java;

import java.util.*;
import java.util.stream.Collectors;

public class TopKElementInList {
    public static void main(String[] args) {
        int [] nums= new int[]{1,1,1,1,2,2,3,3,3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        assert Arrays.equals(new int[] {1, 2}, result) :
                "Expected: " + Arrays.toString(new int[] {1, 3}) +
                        " but was: " + Arrays.toString(result);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> helper = new HashMap<>();
        int[] result = new int[k];
        for (int i = 0 ; i<nums.length ; i++){
            helper.putIfAbsent(nums[i],0);
            helper.put(nums[i] , helper.get(nums[i])+1);
        }

        Map<Integer, Integer> sortedMapDesc = helper.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        Set<Integer> keys = sortedMapDesc.keySet();
        for(int i = 0 ;i < k; i++)
            result[i] = (int) keys.toArray()[i];

        return result;
    }
}
