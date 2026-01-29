package level1.recursion;

//Given an integer N, return the sum of first N natural numbers. Try to solve this using recursion.

public class Sum {

    public static void main(String[] args) {
        System.out.println(sum(10));
    }

    public static int sum(int n){
        
        if(n==0){
            return 0;
        }
return n+sum(n-1); //TC O(n+1=n) //SC O(n stacks)
    }
}
