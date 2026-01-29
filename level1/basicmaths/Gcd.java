package level1.basicmaths;

public class Gcd {
    public static void main(String[] args) {
        System.out.println(gcdcalc(15, 20)); // Output: 5
    }

    public static int gcdcalc(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdcalc(b, a % b);
    }
}

// TC O(log(min a,b))
//No need to check which is bigger as handled automatically ie a>b and b<a