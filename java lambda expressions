import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    interface PerformOperation {
        boolean check(int a);
    }

    static PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }
    static PerformOperation isPrime() {
        return n -> {
            if (n <= 1) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        };
    }

    static PerformOperation isPalindrome() {
        return n -> {
            int original = n;
            int reverse = 0;

            while (n > 0) {
                int digit = n % 10;
                reverse = reverse * 10 + digit;
                n = n / 10;
            }

            return original == reverse;
        };
    }

    static void printResult(boolean result, int type) {
        if (type == 1) {
            System.out.println(result ? "ODD" : "EVEN");
        } 
        else if (type == 2) {
            System.out.println(result ? "PRIME" : "COMPOSITE");
        } 
        else if (type == 3) {
            System.out.println(result ? "PALINDROME" : "NOT PALINDROME");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int type = sc.nextInt();
            int number = sc.nextInt();

            PerformOperation operation;

            if (type == 1) {
                operation = isOdd();
            } 
            else if (type == 2) {
                operation = isPrime();
            } 
            else {
                operation = isPalindrome();
            }

            boolean result = operation.check(number);

            printResult(result, type);
        }

        sc.close();
    }
}
