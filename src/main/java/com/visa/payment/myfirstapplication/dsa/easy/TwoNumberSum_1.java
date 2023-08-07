package com.visa.payment.myfirstapplication.dsa.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum_1 {
    public static int[] sumTwoNumber(int[] input, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        
        int[] output = new int[0];
        if(input == null || input.length < 2) {
            return output;
        }

        for (int i = 0; i < input.length; i++) {
            record.put(input[i], i);
        }

        for (int i = 0; i < input.length; i++) {
            int current = input[0];
            int searchFor = Math.abs(target - current);
            if(record.containsKey(searchFor)) {
                return new int[]{ i, record.get(searchFor) };
            }
        }

        return output;
    }
}
