//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that
//each unique element appears only once. The relative order of the elements should be kept the same.
//Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number          
//of unique elements k.The first k elements of nums should contain the unique numbers in sorted order.
//The remaining elements beyond index k - 1 can be ignored.
import java.util.Arrays;

public class RemoveDuplicates{
    
    public static void main(String args[]){
        
        int[] nums = {1,1,2,3,4,5,5,5,7,8,9};

            int i=0;

            for(int j=1; j<nums.length;j++){

                if(nums[j] != nums[i]){
                    nums[i+1]=nums[j];
                    i++;
                }

            }

            System.out.print(i+1 +  ", nums=");
            System.out.println(Arrays.toString(nums));
    
    }
}