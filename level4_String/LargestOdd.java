package level4_String;

public class LargestOdd {

    public static void main(String[] args) {

        System.out.println(largestOddNumber("52"));      // 5
        System.out.println(largestOddNumber("4206"));    // ""
        System.out.println(largestOddNumber("35427"));   // 35427
        System.out.println(largestOddNumber("123456"));  // 12345
        System.out.println(largestOddNumber("444"));     // ""
    }

    public static String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; i--) {

            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }
}