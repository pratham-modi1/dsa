package level3.medium;

import java.util.Arrays;
import java.util.HashMap;


//Given an array of integers nums and an integer target, return indices of the two numbers such that
//they add up to target.You may assume that each input would have exactly one solution, and you may
//not use the same element twice.
// u can easily get O(n2) TC ill say try for O(n) TC even if u use more space

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3,1};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

     public static int[] twoSum(int[] nums, int target){

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int req = target - nums[i];

            // check first
            if (map.containsKey(req)) {
                return new int[]{map.get(req), i};
            }

            // then store
            map.put(nums[i], i);
        }

        return null; // as per problem, this line is never reached
    }
}

