import java.util.Arrays;

public class Recursiveinsertionsort {

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2};

        insertionsort(arr, 1);

        System.out.println(Arrays.toString(arr));
    }

    static void insertionsort(int[] arr, int n) {

        if (n >= arr.length) {
            return;
        }

        int i = n;

        while (i > 0 && arr[i] < arr[i - 1]) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
            i--;
        }

        insertionsort(arr, n + 1);
    }
}