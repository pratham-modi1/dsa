//Given an array nums containing n distinct numbers in the range [0, n],
//return the only number in the range that is missing from the array.

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4};

        int n = nums.length;  //4,  missing no is 3

        int xor1 = 0;
        int xor2= 0;

        for(int i=0;i<n;i++){

            xor1 = xor1^nums[i];  //0^0^1^2^4

            xor2 = xor2^(i+1);    //0^1^2^3^4

        }

        int xor3 = xor1^xor2; 
        System.out.println(xor3);
    }
}
