
import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] nums = {3,2,1,4};
        int n = nums.length;
        int k = 0;
    
    System.out.print(Arrays.toString(recurse(nums,n,k,false)));
   }


   public static int[] recurse(int[]nums,int n,int j, boolean swapped){
 
    if(n==1){return nums;}

    if(j+1<n){
    if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped=true;
                }
    recurse(nums, n, j+1,swapped);}

    else{
        if (!swapped) return nums;
            recurse(nums, n - 1, 0, false);
    }

    return nums;
}
}

