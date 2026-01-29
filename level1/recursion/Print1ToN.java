package level1.recursion;
import java.util.Scanner;
//Given an integer n, write a function to print all numbers from 1 to n (inclusive) using recursion.
//You must not use any loops such as for, while, or do-while.
//The function should print each number on a separate line, in increasing order from 1 to n.
//Constraints 1<=n<=100

public class Print1ToN{

    public static void main(String[] args) {
        
        System.out.println("Enter n such that 1<=n<=100");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(1<=n && n<=100){
        printfunction(n);
        }
    }

    public static void printfunction(int n){

        if (n==1){
            return;
        }
        printfunction(n-1); //order is very important here as after base case called
                            //then recusrion happens in opposite order
        System.out.println(n);
    }
}