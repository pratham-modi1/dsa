import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {4, 5, 3, 2, 6, 1};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int pidx = partition(arr, low, high);

        quickSort(arr, low, pidx - 1);
        quickSort(arr, pidx + 1, high);
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = low;

        int i = low;
        int j = high;

        while (j > i) {

            while (i <= high && arr[pivot] >= arr[i]) {
                i++;
            }

            while (j >= low && arr[pivot] < arr[j]) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;

        return j;
    }
}