package com.visa.payment.myfirstapplication.dsa.medium;

import java.util.*;

/*
Approach

Sort the input array nums in ascending order. This allows us to easily eliminate duplicate values and manipulate the pointers efficiently.
Iterate over the sorted array using a loop. Let the current index be i.
Inside the loop, handle duplicate values. If i is greater than zero and the current element is the same as the previous element, skip to the next iteration.
Initialize two pointers: j pointing to the element after i, and k pointing to the last element in the array.
Enter a while loop with the condition j < k. This loop will continue until the pointers meet.
Calculate the sum of the elements at indices i, j, and k: sum = nums[i] + nums[j] + nums[k].
If sum is less than zero, increment j to move towards higher values.
If sum is greater than zero, decrement k to move towards lower values.
If sum is equal to zero, we have found a valid triplet. Create a temporary vector temp and store the values nums[i], nums[j], and nums[k] in it. Add temp to the final result vector ans.
Increment j and decrement k to continue searching for more triplets.
Handle duplicate values by skipping over them. If j is still less than k and the current element is the same as the previous element, increment j and decrement k again.
Once the while loop ends, continue with the next iteration of the outer loop, incrementing i.
After all iterations, return the final result vector ans.
This approach ensures that we cover all possible triplets that sum up to zero while avoiding duplicates.
 */
public class ThreeNumberSum_1 {
    public static List<List<Integer>> threeSum(int[] input) {
        List<List<Integer>> result = new ArrayList<>();

        if(input == null || input.length < 3) { // If array size is < 3, means no triplet would exist from that array. Return empty vector of vectors.
            return result;
        }

        Arrays.sort(input);

        if(input[0] > 0) { // If first element is +ve, that means there is no -ve number by which we can make a 0 triplet sum. Return empty vector of vectors.
            return result;
        }


        for (int i = 0; i < input.length; i++) {
            int current = input[i];

            if(current > 0){   //If number fixed is +ve, stop there because we can't make it zero by searching after it.
                break;
            }

            if(i > 0 && input[i] == input[i -1]) { //If number is getting repeated, ignore the lower loop and continue.
                continue;
            }

            int left = i + 1, right = input.length - 1; //Make two pointers high and low, and initialize sum as 0.
            int sum;
            while (left < right) { //Search between two pointers, just similar to binary search.
                sum = input[left] + input[right] + input[i];

                if(sum > 0){   //If sum is +ve, means, we need more -ve numbers to make it 0, decreament right (right--).
                    right--;
                } else if(sum < 0){ //If sum is -ve, means, we need more +ve numbers to make it 0, increament left (left++).
                    left++;
                } else {
                    List<Integer> occurence = List.of(input[i],  input[left], input[right]); //we have found the required triplet, push it in answer vector
                    result.add(occurence);
                    int last_low_occurence = input[left] , last_high_occurence = input[right];  //Now again, to avoid duplicate triplets, we have to navigate to last occurences of num[left] and num[right] respectively
                    while(left < right && input[left] == last_low_occurence){   // Update the low and high with last occurences of low and high.
                        left++;
                    }
                    while(left < right && input[right] == last_high_occurence){
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
