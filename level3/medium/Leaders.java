//Given an integer array nums, return a list of all the leaders in the array.
//A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. The rightmost element is always a leader. 
//The elements in the leader array must appear in the order they appear in the nums array.

import java.util.ArrayList;
import java.util.List;

public class Leaders{
    public static void main(String[] args) {
         
        int[] nums = {1, 2, 5, 3, 1, 2};   
        System.out.println(leaders(nums));
        
    }

    public static List<Integer> leaders(int[] nums){  //O(n) tc

        int max = nums[nums.length-1];

        List<Integer> list = new ArrayList<>();
        list.add(max);
        
        
        for(int i = nums.length-2;i>=0;i--){

            if(nums[i]>max){
                max=nums[i]; 
                list.add(max);
            }

        }
        return list.reversed();   
    }

}