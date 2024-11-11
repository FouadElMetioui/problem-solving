package com.letcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramGroups {
    public static void main(String[] args) {
        String[] strs = new String[]{"act","pots","tops","cat","stop","hat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        ArrayList<Integer> checked = new ArrayList<>();
        if (strs.length == 1 ){
            result.add(List.of(strs[0]));
            return result;
        }
        for(int i = 0; i< strs.length ; i++){
            List<String> current = new ArrayList<>();
            if (!checked.contains(i)) {
                current.add(strs[i]);
            }
            for (int j = i+1 ; j< strs.length; j++) {
                if (isAnagram(strs[i],strs[j])){
                    current.add(strs[j]);
                    checked.add(j);
                }
            }
            if (!checked.contains(i)){
                result.add(current);
            }


        }

        return result;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        for (int i = 0; i < t.length(); i++) {
            int e = s.indexOf(t.charAt(i));
            if (e == -1)
                return false;
            else {
                s = s.substring(0, e) + s.substring(e + 1);
            }
        }
        return true;

    }
}
