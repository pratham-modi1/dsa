import java.util.Arrays;

public class Sort1and0{
    public static void main(String[] args) {
        int[] nums = {0,1,1,0,1,1};

        int left = 0;
        int right = nums.length-1;

        while(left<right){

            while(left<right && nums[left]==0){
                left++;
            }

            while(left<right && nums[right]==1){
                right--;
            }

            if(left<right){
                int temp = nums[right];
                nums[right]=nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
        }


        System.out.println(Arrays.toString(nums));
    }
}
//for this specific problem, your O(n) method is better than QuickSort. But not in general.
