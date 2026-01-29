//Given an array of integers nums, every element appears twice except for one. Find that single one
// TC O(n) and SC O(1)

public class SingleNumber{
    public static void main(String[] args) {

        //brute force approach : hashing by hashmap
        int[] nums = {4,1,2,1,2};

        int xor = 0;
        
        for(int i = 0; i < nums.length; i ++){
                  xor = xor^nums[i];
        }
        System.out.println(xor);

      
}}