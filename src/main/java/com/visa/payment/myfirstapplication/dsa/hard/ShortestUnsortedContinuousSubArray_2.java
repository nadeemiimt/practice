package com.visa.payment.myfirstapplication.dsa.hard;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubArray_2 {
    public int findUnsortedSubArray(int[] nums) {
        int[] tmp = new int[nums.length];

        System.arraycopy(nums, 0, tmp, 0, nums.length);

        Arrays.sort(nums);

        int s = 0;
        int end = nums.length;

        for(; s < nums.length; s++) {
            if(nums[s] != tmp[s]){
                break;
            }
        }

        if (s >= nums.length - 1) {
            return 0;
        }

        for(; end >=0; end--) {
            if(nums[end] != tmp[end]) {
                break;
            }
        }

        return end - s + 1;
    }

    public int findUnsortedSubArray1(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 1; i< nums.length; i++) {
            if(nums[i -1] > nums[i]) {
                min = Math.min(nums[i], min);
            }
        }

        for(int i = nums.length -2; i>= 0; i--) {
            if(nums[i] > nums[i + 1]) {
                max = Math.max(nums[i], max);
            }
        }

        if(min==Integer.MAX_VALUE && max==Integer.MIN_VALUE) return 0; // finding if array is already sorted: if sorted then return 0

                //If array is not sorted
                int start=0, end=nums.length-1;
                for(;start<nums.length;start++){ // finding start point
                    if(nums[start]>min) break; // find index in the left for a no. greater than the min found
                }
                for(;end>=0;end--){ // finding end point
                    if(nums[end]<max) break; // find index in the right for a no. lesser than the max found
                }
                return end-start+1; // ans: unsorted array
    }
}
