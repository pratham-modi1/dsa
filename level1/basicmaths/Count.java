package level1.basicmaths;
import java.util.ArrayList;
import java.util.Scanner;

public class Count{
public static void main(String[] args) {
    functionf1();
    //You are given an integer n. You need to return the number of digits in the number.
    // The number will have no leading zeroes, except when the number is 0 itself.
    // 0 <= n <= 5000
}
//lengthy method not reqd just use count++ no need to create and store in arraylist
public static void functionf1(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a no. between 0 and 5,000: ");
    int num = sc.nextInt();
    
    if(0<=num && num<=5000){
        ArrayList<Integer> list = new ArrayList<>();

        while(num!=0){
            list.add(num%10);
            num/=10;        //no of iteration is based on division so TC is logarithmic
        }                   // since we divide by 10 so TC: O(logN) base "10"

        System.out.println("Count of digits is "+ list.size());
    }
    else{
        //reprompt 
        functionf1();
    }



}
}  
