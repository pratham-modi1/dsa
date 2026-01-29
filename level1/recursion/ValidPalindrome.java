package level1.recursion;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
    }

    public static boolean isPalindrome(String s){
        String result = s.toLowerCase().replaceAll("[^a-z0-9]", "");
       
        for (int i=0;i<result.length()/2;i++){
            if(result.charAt(i) != result.charAt(result.length()-i-1)){
                    return false;    }
                }

        return true;
    }
}
