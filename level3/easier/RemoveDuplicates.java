// RemoveDuplicates.java
class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums.length == 0) {
            return 0;
        }

        int test = nums[0];
        int i = 1; // read pointer
        int j = 1; // write pointer

        while (i < nums.length) {

            if (nums[i] != test) {
                nums[j] = nums[i];
                j++;
            }

            test = nums[i];
            i++;
        }

        return j;
    }
}