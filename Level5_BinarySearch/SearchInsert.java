package Level5_BinarySearch;

public class SearchInsert {
    
     public static void main(String[] args) {

        System.out.println("Hello World, entering the program");

        int[] nums = {1,1,3,5,6,10};
        int target = 2;   //answer shud be 2

        int low = 0;
        int high = nums.length - 1;

        int idx = nums.length;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                idx = mid;
                System.out.println(idx);
                return;
            }

            else if (nums[mid] < target) {
                low = mid + 1;
            
            }

            else {  //if target<nums[mid]
                high = mid - 1;
                idx = mid;
            }
        }

        System.out.println(idx);
    }
}
