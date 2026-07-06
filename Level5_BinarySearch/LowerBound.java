package Level5_BinarySearch;

public class LowerBound {
 
    //return idx of first element ie greater than eql to the target

    public static void main(String[] args) {
        int[] nums = {3,5,8,15,19};  

        int target = 9;
        int low = 0;
        int high = nums.length - 1;
        int idx = nums.length;

        int mid = (low + high)/2;   

        while(low<=high) {       

            if(target < nums[mid]){       
                high = mid - 1;
                idx = mid;
            }
            else if (target > nums[mid]){     
                low = mid + 1;     
            }

            else {
                idx = mid;   //discard full right side!
                high = mid-1;
            }

            mid = (low + high)/2;    

        
        }

        System.out.println(idx);
    }
}
