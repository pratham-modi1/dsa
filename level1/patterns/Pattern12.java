package level1.patterns;

public class Pattern12 {

    public static void main(String[] args) {

        int n = 5;
        int width = 2 * n;

        for (int i = 1; i <= n; i++) {

            // first half
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // spaces
            for (int j = 1; j <= width - 2 * i; j++) {
                System.out.print(" ");
            }

            // second half (mirror)
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}
