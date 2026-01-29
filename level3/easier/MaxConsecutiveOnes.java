public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1,1,1};

        int max = 0;
        int count = 0;
        for(int i=0; i < nums.length; i++){
        
            if(nums[i]==1){
                count++;
            }
            else{
                if(max<count){    
                       max = count;
                    }    
                    count = 0;
                }
            }

     if(max<count){    
           max = count;
                    }  


    System.out.println(max);


}
}
