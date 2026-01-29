package level1.hashing;
import java.util.*;

public class Chaining {
    public static void main(String[] args) {

        int[] arr = {2, 5, 16, 28, 139, 38, 48, 28, 18};

        // Step 1: create hash table of size 10
        @SuppressWarnings("unchecked")
        List<Integer>[] hash = new ArrayList[10];

        // Step 2: initialize each bucket
        for (int i = 0; i < 10; i++) {
            hash[i] = new ArrayList<>();
        }

        // Step 3: store elements using chaining
        for (int num : arr) {
            int index = num % 10;
            hash[index].add(num);
        }

        // Step 4: print hash table
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " -> " + hash[i]);
        }

        // Step 5: fetch frequency of a number
        int target = 28;
        int idx = target % 10;
        int freq = 0;

        for (int x : hash[idx]) {
            if (x == target) {
                freq++;
            }
        }

        System.out.println("Frequency of " + target + " = " + freq);
    }
}
