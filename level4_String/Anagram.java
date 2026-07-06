package level4_String;

public class Anagram {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] hash = new int[256];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
            hash[t.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }

        return true;
    }
}