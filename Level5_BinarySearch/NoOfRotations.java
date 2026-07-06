    package Level5_BinarySearch;

    public class NoOfRotations {

        public static void main(String[] args) {

            int[] nums = {6, 1, 2, 3, 4, 5};

            int low = 0;
            int high = nums.length - 1;
            int mid = (low + high) / 2;

            if(nums.length == 1){ 
                System.out.println(0);
                return; }

            if (nums[mid] >= nums[low] && nums[mid] <= nums[high]) {
                System.out.println(0);
                return;
            } 
            else {

                while (low <= high) {

                    if (nums[mid] < nums[low]) {
                        high = mid;
                    } else if (nums[mid] >=  nums[high]) {
                        low = mid + 1;
                    }

                    if (high == low) {
                        System.out.println(high);
                        return;
                    }

                    if(nums[mid] >= nums[low] && nums[mid] <= nums[high]){
                        System.out.println(low);
                        return;
                    }
                    mid = (low + high) / 2;

                
                }


            }
        }
    }