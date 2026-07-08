// package level4_String;

// public class OutermostParenthesis {
//     public static void main(String[] args) {
    
//         String s = "(()()) (()) (()(()))";   // ()() )( () )( () (())  
//                                                // ()()  ()  ()(())
//         System.out.println(removeOuterParentheses(s));
//     }

//     public static String removeOuterParentheses(String s) {

        
//         //condition
//         // ignore if same, put if different  

//         s = s.substring(1, s.length());
//         //this removes outermost brackets
//         String arr[] = s.toString();
//         String p = "";

//         for(int i=0; i < s.length()-1 ;i++){

//             if( arr[i] == "(" && arr[i+1]== ")" ){
//                // p += s[i];
//              //   p += s[i+1];
//             }
//         }


        
//         return null;
//     }

// }
