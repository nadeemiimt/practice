package com.visa.payment.myfirstapplication.dsa.easy;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class CheckSubSequence_2 {
    public boolean isSubsequence(String s, String t) {
        if(t == null || t.length() < t.length()) {
            return false;
        }

        boolean result = false;
        char[] subArray = s.toCharArray();

        char[] inputArray = t.toCharArray();

        if(subArray != null && subArray.length > 0){
            int tracker = 0;
            for(int i = 0; i < inputArray.length; i++) {
                char f = subArray[tracker];
                if(f == inputArray[i]) {
                    tracker++;

                    if(tracker == subArray.length) {
                        result = true;
                        break;
                    }
                }
            }
        } else {
            return true;
        }

        return result;
    }
}
