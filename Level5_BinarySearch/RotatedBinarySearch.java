    package Level5_BinarySearch;

    public class RotatedBinarySearch {

        public static void main(String[] args) {

            int[] arr = {4, 5, 6, 7, 0, 1, 2};
            int target = 0;

            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {

                int mid = (low + high) / 2;

                // Target found
                if (arr[mid] == target) {
                    System.out.println("Index is " + mid);
                    return;
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

            System.out.println("Target not found");
        }
    }