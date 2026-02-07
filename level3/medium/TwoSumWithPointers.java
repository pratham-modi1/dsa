
//if u do arr.sort then original indexes are destroyed hence we use 2d array ie store idx and val
import java.util.*;

//total tc is O(nlogn+n) == O(nlogn)  sc=O(n)

public class TwoSumWithPointers {
    public static int[] twoSum(int[] nums, int target) {

        // Step 1: store value + original index
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // original index
        }

        // Step 2: sort by value  timsort nlogn
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // Step 3: two pointers on sorted values
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {  //O(n)
            int sum = arr[left][0] + arr[right][0];

            if (sum == target) {
                return new int[]{arr[left][1], arr[right][1]};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return null; // guaranteed solution exists
    }
}
