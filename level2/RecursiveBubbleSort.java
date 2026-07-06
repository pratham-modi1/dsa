import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4};

        recurse(nums, nums.length, 0, false);

        System.out.println(Arrays.toString(nums));
    }

    static void recurse(int[] nums, int n, int j, boolean swapped) {

        if (n == 1) {
            return;
        }

        if (j + 1 < n) {

            if (nums[j] > nums[j + 1]) {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
                swapped = true;
            }

            recurse(nums, n, j + 1, swapped);

        } else {

            if (!swapped) {
                return;
            }

            recurse(nums, n - 1, 0, false);
        }
    }
}