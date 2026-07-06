package Level5_BinarySearch;

public class SingleDuplicate {
    
    public static void main(String[] args) {
        
       
        int[] nums = {1,1,2,3,3,4,4}; 
        

        int n = nums.length;

        int low = 0;
        int high = n-1;
      if (n == 1) {
    return;
}

        if(nums[0] != nums[1]){
            System.out.println(nums[0]);
            return;
        }
        
        if(nums[n-1]!= nums[n-2]){
            System.out.println(nums[n-1]);
            return;
        }

 


    while(low<=high){

        int mid = (low+high)/2;


        if(mid!=0 && mid!=n-1){
            if(nums[mid] != nums[mid-1] && nums[mid]!=nums[mid+1]){
                System.out.println(nums[mid]);
                return;
        }}


        if(mid %2 == 0){
            if(nums[mid] == nums[mid-1]){
                //target on lhs
                high = mid;
            }
            else if(nums[mid] == nums[mid+1]){
                //target on right
                low = mid;
            }
        }
        else{

            if(nums[mid] == nums[mid+1]){
                //target on left;
                high = mid+1;
            }
            else if(nums[mid] == nums[mid-1]){
                //target on right;
                low = mid-1;  
            }
        }

    }

    }
}
