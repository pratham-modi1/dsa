package level1.basicmaths;

public class Palindrome {
    
    public static void main(String[] args) {
     //call method
     System.out.println(palindromechecker(-121));   
    
    }

    public static boolean palindromechecker(int n){
         int rev=0;
        int temp = n;

        while(n>0){              
            int dig = n%10;       
            n/=10;               

            rev = 10*rev+dig; 
        }

        return rev==temp;
    }
}

       