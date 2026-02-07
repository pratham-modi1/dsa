import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        
        int nums[] = {0,2,1,0,1,2};

        int low = 0;
        int mid = 0;
        int high = nums.length-1; 

        
        while(mid<=high){

            if(nums[mid]==0){
                swap(nums, mid, low);
                low++;
                mid++;
            }

            else if(nums[mid]==1){
                mid++;
            }

            else{
                swap(nums, mid, high);
                high--;
            }
        }

        System.out.println(Arrays.toString(nums));


    }

    public static void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right]=temp;
    }

}
