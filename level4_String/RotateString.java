package level4_String;  //package first then import if needed

public class RotateString {

    public static void main(String[] args) {
        
        String s ="abcde";
        String goal = "cdeab";

        System.out.println(isrotatestring(s,goal));
    }

    public static boolean isrotatestring(String s, String goal) {
        
        int n = s.length();
        int n2 = goal.length();

        if(n != n2){ return false;}

        String s2 = s + s;
        if(s2.contains(goal)){
            return true;
        }

    
        return false;
    }
    
}
