package Level5_BinarySearch;

public class FloorAndCeiling {
    
    public static void main(String[] args) {
        
        int nums[] = {3};
        int low = 0;
        int high = nums.length -1;
        int mid = (low+high)/2;
        int target = 4;
        int floor=-1;  
        int ceiling=-1;

        while(low<=high){

            if(nums[mid]==target){
                floor = target;
                ceiling = target;
                break;
            }
            
            if(nums[mid]>target){
                high = mid-1;
                ceiling = nums[mid];
            }
            else{
                low = mid+1;
                floor = nums[mid];
            }

            mid = (low+high)/2;

        }



        System.out.println("Floor is " + floor + " and Ceiling is " + ceiling);
    }
}
