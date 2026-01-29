package level1.recursion;

//Problem Description: Given an integer N, write a program to print your name N times.
public class PrintName{

    public static void main(String[] args) {
        retName("Pratham",5,0); //N times called so TC = O(N)
    }                                              //SC = O(N) stack space used for recursive calls

    public static void retName(String names, int times,int count){

        if(count==times){
            return;
        }
        else{
            count++;
        }

        System.out.println(names);
        retName(names,times,count);
    }

}