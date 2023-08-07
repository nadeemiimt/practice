package com.visa.payment.myfirstapplication.dsa.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference_2 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        if(arr == null || arr.length <= 1) {
            return result;
        }

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length -1; i++) {
            int currDiff = arr[i + 1] - arr[i];
            if(currDiff <= minDiff) {
                if(currDiff < minDiff) {
                    minDiff = currDiff;
                    result.clear();
                }

                List<Integer> occ = new ArrayList<>();
                occ.add(arr[i]);
                occ.add(arr[i + 1]);

                result.add(occ);
            }
        }

        return result;
    }

    public List<List<Integer>> minimumAbsDifferenceAnother(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        if(arr == null || arr.length <= 1) {
            return result;
        }

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length -1; i++) {
            int currDiff = arr[i + 1] - arr[i];
            if (currDiff <= minDiff) {
                minDiff = currDiff;
            }
        }

        for(int i = 0; i < arr.length -1; i++) {
            int currDiff = arr[i + 1] - arr[i];
            if(currDiff == minDiff) {
                List<Integer> occ = new ArrayList<>();
                occ.add(arr[i]);
                occ.add(arr[i + 1]);

                result.add(occ);
            }
        }

        return result;
    }
}
