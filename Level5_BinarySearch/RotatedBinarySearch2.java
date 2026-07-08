package Level5_BinarySearch;

public class RotatedBinarySearch2 {

    public static void main(String[] args) {

        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;

        int low = 0;
        int high = arr.length - 1;
        boolean found = false;

        while (low <= high) {

            int mid = (low + high) / 2;

            // Target found
            if (arr[mid] == target) {
                System.out.println("Target found");
                found = true;
                break;
            }

            // Ambiguous case due to duplicates
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (arr[low] <= arr[mid]) {

                // Check if target lies in left half
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Right half is sorted
            else {

                // Check if target lies in right half
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        if (!found) {
            System.out.println("Target not found");
        }
    }
}