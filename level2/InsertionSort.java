import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        
        int[] nums = {14,9,15,12,6,8,13};
        int n = nums.length;

        for (int i = 1; i < n; i++) {

            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break; 
                }
            }
        }

    System.out.print(Arrays.toString(nums));
    
    
        }
}








