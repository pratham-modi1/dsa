package Level5_BinarySearch;

public class UpperBound {

    // Returns the index of the first element strictly greater than target.
    // If no such element exists, returns nums.length.

    public static void main(String[] args) {

        int[] nums = {3, 5, 8, 15, 19};
        int target = 9;

        int low = 0;
        int high = nums.length - 1;

        // Default answer: "not found"
        int idx = nums.length;

        while (low <= high) {

            int mid = (low + high) / 2;

            // nums[mid] is a valid candidate
            if (nums[mid] > target) {
                idx = mid;          // Save current answer
                high = mid - 1;     // Try to find an earlier one
            }

            // nums[mid] cannot be the answer
            else {
                low = mid + 1;
            }
        }

        System.out.println(idx);
    }
}