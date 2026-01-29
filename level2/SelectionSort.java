import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {4, 3, 78, 7, 77, 4, 2, 1};
        System.out.println(Arrays.toString(sel(nums)));
    }

    public static int[] sel(int[] nums) {

        int n = nums.length;

        for (int i = 0; i <= n - 2; i++) {

            int min = i;

            // find index of minimum element
            for (int j = i + 1; j <= n - 1; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            // swap AFTER inner loop
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }

        return nums;
    }
}
