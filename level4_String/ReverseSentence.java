package level4_String;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseSentence {

    public static void main(String args[]) {

        String s = "  the sky is blue     ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {

        int length = s.length();

        ArrayList<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < length; i++) {

            // Skip leading and trailing spaces
            if (str.length() == 0 && s.charAt(i) == ' ') {
                continue;
            }

            // Skip multiple spaces
            if (i > 0 && s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') {
                continue;
            }

            else if (s.charAt(i) != ' ') {

                str.append(s.charAt(i));

                // Last character of string
                if (i == length - 1) {
                    list.add(str.toString());
                }

            } else {

                list.add(str.toString());
                str.setLength(0); // reset
            }
        }

        Collections.reverse(list);

        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {

            newStr.append(list.get(i));

            if (i != list.size() - 1) {
                newStr.append(" ");
            }
        }

        return newStr.toString();
    }
}