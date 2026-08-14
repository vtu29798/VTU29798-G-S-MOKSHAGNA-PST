import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();

            int[] z = new int[n];

            int left = 0;
            int right = 0;

            // Z-Algorithm
            for (int i = 1; i < n; i++) {

                if (i <= right) {
                    z[i] = Math.min(right - i + 1, z[i - left]);
                }

                while (i + z[i] < n &&
                       s.charAt(z[i]) == s.charAt(i + z[i])) {
                    z[i]++;
                }

                if (i + z[i] - 1 > right) {
                    left = i;
                    right = i + z[i] - 1;
                }
            }

            // Similarity of the string with itself
            long answer = n;

            // Add similarities of all other suffixes
            for (int i = 1; i < n; i++) {
                answer += z[i];
            }

            System.out.println(answer);
        }

        sc.close();
    }
}
