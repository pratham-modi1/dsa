public class Practice {
         public static void main(String[] args) {
         int[] nums = {1,2,3,4,5,6,7,8,9};  


         int n = nums.length;
         
         for(int k = 0; k<nums.length ; k++){
         nums = new int[]{1,2,3,4,5,6,7,8,9};
         int low = nums[0];
         boolean issorted = true;

         for(int i = 0 ; i < k/2 ; i++){

            int temp = nums[i];
            nums[i]= nums[k-1-i];
            nums[k-i-1] = temp;
         }


         for(int i = k ; i< k + (n-k)/2 ; i++){   

            int temp = nums[i];
            nums[i] = nums[n-1+k-i];
            nums[n-1+k-i] = temp;
         }

           for(int j = 0 ; j<nums.length/2 ; j++){
            int temp = nums[j];
            nums[j]= nums[n-1-j];
            nums[n-j-1] = temp;
           }


           //now to check if sorted 
           for(int i =0 ; i<nums.length-1 ; i++){
            if(nums[i]>nums[i+1]){
               issorted = false;
            }
            
           }
           if(issorted == true){ return issorted;}
           

   
      }
    }}