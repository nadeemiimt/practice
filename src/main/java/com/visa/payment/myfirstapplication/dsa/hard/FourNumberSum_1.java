package com.visa.payment.myfirstapplication.dsa.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumberSum_1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i -1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) continue;

                int left = j+1, right = nums.length - 1;

                long rest = (long) target - nums[i] - nums[j];
                int currentSum;
                while (left < right) {
                    currentSum = nums[left] + nums[right];
                    if(currentSum > rest) {
                        right--;
                    } else if (currentSum < rest) {
                        left++;
                    } else {
                        List<Integer> occ = new ArrayList<>();
                        occ.add(nums[i]);
                        occ.add(nums[j]);
                        occ.add(nums[left]);
                        occ.add(nums[right]);

                        result.add(occ);

                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left -1]){   // Update the low and high with last occurences of low and high.
                            left++;
                        }
                        while(left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }
                }

            }
        }

        return result;
    }
}
