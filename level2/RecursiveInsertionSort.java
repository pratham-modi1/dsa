import java.util.Arrays;

public class RecursiveInsertionSort {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};

        insertionSort(nums, nums.length);

        System.out.println(Arrays.toString(nums));
    }

    // Recursive insertion sort
    static void insertionSort(int[] nums, int n) {

        // Base case: single element is already sorted
        if (n <= 1) {
            return;
        }

        // Sort first n-1 elements
        insertionSort(nums, n - 1);

        // Insert nth element into sorted part
        int key = nums[n - 1];
        int j = n - 2;

        // Shift elements to make space for key
        while (j >= 0 && nums[j] > key) {
            nums[j + 1] = nums[j];
            j--;
        }

        nums[j + 1] = key;
    }
}
