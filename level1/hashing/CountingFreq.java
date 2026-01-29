package level1.hashing;

import java.util.*;

public class CountingFreq {
    
    public static void main(String[] args) {
        
        int[] arr ={1,2,3,4,1,2};
        System.out.println(countFrequencies(arr));
    }

    public static List<List<Integer>> countFrequencies(int[] nums) {
        // Your code goes here

        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            int key = nums[i];
            int freq = 0;
            if(hash.containsKey(key)){
                freq = hash.get(key);
            }
            freq++;
            hash.put(key, freq);
        }

        //now lets move
        List<List<Integer>> lists = new ArrayList<>();

           for (Map.Entry<Integer, Integer> it : hash.entrySet()) {
            System.out.println(it.getKey() + "->" + it.getValue());

            List<Integer> sublist = new ArrayList<>();
            sublist.add(0,it.getKey());
            sublist.add(1,it.getValue());

            lists.add(sublist);

           // lists.add(new ArrayList<>().add(it.getKey(),it.getValue()));

        }


        return lists;} 
    }
