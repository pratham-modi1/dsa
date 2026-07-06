package Level5_BinarySearch;

public class BinarySearch {

    // Find the target in the sorted array and return its index.
    // If the target is not present, return -1.

    public static void main(String[] args) {

        System.out.println("Hello World, entering the program");

        int[] nums = {1,2,3,4,6};
        int target = 2;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                System.out.println(mid);
                return;
            }

            else if (nums[mid] < target) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        System.out.println(-1);
    }
}