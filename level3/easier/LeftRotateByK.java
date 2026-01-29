import java.util.Arrays;

public class LeftRotateByK {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        int k = 5 % arr.length;

        // Step 1: reverse first k elements
        reverse(arr, 0, k - 1);

        // Step 2: reverse remaining elements
        reverse(arr, k, arr.length - 1);

        // Step 3: reverse whole array
        reverse(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    // helper function to reverse array from left to right index
    static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
