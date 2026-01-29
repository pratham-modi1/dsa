package level1.basicmaths;
import java.util.ArrayList;
import java.util.Arrays;
//you can use count>2 (1 and no itself) method to find if a no. is prime or not using same code
//no need to use ArrayList 
public class Divisors {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divisors(36)));
    }

public static int[] divisors(int n) {
ArrayList<Integer> list = new ArrayList<>();
    
if(1<=n && n<=1000){

    for(int i=1; i*i<=n;i++){        //if i<n then TC = O(n), if i<sqrt(n) then TC = O(sqrt(n))
        if (n%i==0){ 
            list.add(i);

            if(i!=n/i){
            list.add(n/i);
        }
    }}}

        list.sort((Integer a, Integer b)-> a-b); //java uses timsort tc is dlogd base2
 //net tc is O(sqrootn) + O(dlogd base 2) where d = no of divisors      
//timsort is faster than bubble sort O(n2)

        int arr[] = new int[list.size()];

        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
                }
return arr;
}

}