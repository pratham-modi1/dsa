package level4_String;


public class LongestCommonPrefix {
    
    public static void main(String[] args) {

        String[]  strs = {"flower","flow","flight"};
        String str = prefix(strs);
        //brute force approach
        System.out.println(str);
        }


    public static String prefix(String[] strs) {
        int n = strs.length;
        int minLength = strs[0].length();


        for(int i = 0; i< n; i++){   //tc O()
            if(strs[i].length()<minLength){
                minLength = strs[i].length();
            }
        }

        //found out minlength now lets compare
        String result = "";
       
        
        for(int i = 0; i<minLength;i++){
            
            char firstchar = strs[0].charAt(i);
            
               for(int j = 0; j < strs.length; j++){
        
               if(strs[j].charAt(i) != firstchar){
                  return result;
                      }
                    }

        result += firstchar;
    
}


        return result; 
        
    }
}
