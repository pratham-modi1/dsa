package Level5_BinarySearch;

public class Peak {

    public static void main(String[] args) {

        int[] nums = {7};

        if(nums.length==1){
            System.out.println(nums[0]);
            return;
        }
        if (nums[0] > nums[1]) {
            System.out.println(nums[0]);
            return;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            System.out.println(nums[nums.length - 1]);
            return;
        }

        int low = 0;
        int high = nums.length - 1;

        while (true) {

            int mid = (low + high) / 2;

            if (low == high && high == mid) {
                System.out.println(nums[mid]);
                return;
            }

            if (nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                high = mid;
            }
}

    }
}