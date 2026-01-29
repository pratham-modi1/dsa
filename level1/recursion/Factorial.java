package level1.recursion;

public class Factorial {

     public static void main(String[] args) {
        System.out.println(factos(4));
    }

    public static int factos(int n){
        
        if(n==0){  // 0! = 1
            return 1;
        }
return n*factos(n-1); //TC O(n+1=n) //SC O(n stacks)
    }

}
