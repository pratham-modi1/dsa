package level1.recursion;

public class Reverse {
    public static void main(String[] args) {
        
        char[] s = {'p','r','a','t','h','a','m'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        int left =0;
        int right = s.length-1;        
        while (left<right){

            char i = s[left];

            s[left]=s[right];
            s[right]= i;

            left++;
            right--;
        }
        System.out.println(s);            
}
}
