public class LongestSubarray {
    public static void main(String[] args) {

        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        int maxLen = 0;
        int startIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    int len = j - i + 1;

                    if (len > maxLen) {
                        maxLen = len;
                        startIndex = i;
                    }
                }
            }
        }


        // print result
        if (maxLen > 0) {
            System.out.print("Longest subarray: ");
            for (int x = startIndex; x < startIndex + maxLen; x++) {
                System.out.print(nums[x] + " ");
            }
            System.out.println("\nLength = " + maxLen);
        } else {
            System.out.println("No subarray found");
        }
    }
    
}
