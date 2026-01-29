package level1.basicmaths;
import java.util.ArrayList;

//much lengthier method. palindrome tells easier on pt methofd
public class Reverse {

    public static void main(String[] args) {
        System.out.print(reversed(1534236469));
    }
    
  public static int reversed(int x) {
        
          long output = 0;
       
            
            ArrayList<Integer> number = new ArrayList<>();
            
            while(x!=0){
                number.add(x%10);
                x/=10;  //TC logN base10
            }
            
            
            for(int i=0;i<number.size();i++){

                output += number.get(i)*((int)Math.pow(10,number.size()-1-i));
                 if (output > Integer.MAX_VALUE || output < Integer.MIN_VALUE)
            return 0;
            } 


             if (output > Integer.MAX_VALUE || output < Integer.MIN_VALUE) {
        return 0;
    }

  return (int)output;}}