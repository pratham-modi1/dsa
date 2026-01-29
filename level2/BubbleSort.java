//“Is bubble sort ever useful?”
//“Yes — when the array is almost sorted, bubble sort with early termination performs in O(n), 
//and recursive versions help demonstrate recursion mechanics clearly.

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        
//worst case TC O(n2)
        int[] nums = {3,2,1,4};
        int n = nums.length;

       for (int i = 0; i <= n - 2; i++) {

            int swap = 0;

            for (int j = 0; j <= n - 2 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swap++;
                }
            }

            if (swap == 0) {
                break;
            }
        }


    System.out.print(Arrays.toString(nums));
   }
}
