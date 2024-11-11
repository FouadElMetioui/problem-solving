package com.letcode.java;

import java.util.ArrayList;
import java.util.HashSet;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("saaa", "aass"));
    }

    /***
     * aaba aabb
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        for (int i = 0; i < t.length(); i++) {
            int e = s.indexOf(t.charAt(i));
            if (e == -1)
                return false;
            else {
                s = s.substring(0, e) + s.substring(e + 1);
                System.out.println(s);
            }
        }
        return true;

    }
}
