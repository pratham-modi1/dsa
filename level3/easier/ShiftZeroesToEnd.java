    import java.util.Arrays;

    public class ShiftZeroesToEnd {

        public static void main (String args[]){

            int[] arr = {0,0,1,2};

            int j = Integer.MIN_VALUE;
            
            for(int i=0;i<arr.length;i++){   //O(n-x)
                if(arr[i] == 0){
                    j = i;
                    break;
                }
            }

            if (j == Integer.MIN_VALUE) {
    System.out.println(Arrays.toString(arr));
    return;
}

            for(int i=j+1;i<arr.length;i++){ //O(x) //net is O(n-x+x) = O(n)

                if(arr[i]!=0){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j]=temp;
                    j++;
                }
            }

            
            System.out.println(Arrays.toString(arr));
            
        }

    }
