package Level5_BinarySearch;

public class FirstAndLastPosition {

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int idx1 = -1;
        int idx2 = -1;

        // ---------- First Occurrence ----------
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                idx1 = mid;
                high = mid - 1;      // Continue searching on the left
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        // ---------- Last Occurrence ----------
        low = 0;
        high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                idx2 = mid;
                low = mid + 1;       // Continue searching on the right
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        System.out.println("First Occurrence = " + idx1);
        System.out.println("Last Occurrence  = " + idx2);
    }
}