public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {1};

        int largest = arr[0];
        int secondlargest = Integer.MIN_VALUE;
        boolean foundSecond = false;

        for(int i = 0; i < arr.length; i++){

            if(arr[i] > largest){
                secondlargest = largest;
                largest = arr[i];
                foundSecond = true;
            }
            else if(arr[i] < largest){
                if(arr[i] > secondlargest){
                    secondlargest = arr[i];
                    foundSecond = true;
                }
            }
        }

        if(!foundSecond){
            System.out.println("Second largest element does not exist");
        } else {
            System.out.println(largest + " " + secondlargest);
        }
    }
}
