import java.util.*;

class Student {}
class Rockstar {}
class Hacker {}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Object> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            if (s.equals("Student"))
                list.add(new Student());
            else if (s.equals("Rockstar"))
                list.add(new Rockstar());
            else
                list.add(new Hacker());
        }

        int student = 0, rockstar = 0, hacker = 0;

        for (Object obj : list) {
            if (obj instanceof Student)
                student++;
            if (obj instanceof Rockstar)
                rockstar++;
            if (obj instanceof Hacker)
                hacker++;
        }

        System.out.println(student + " " + rockstar + " " + hacker);
    }
}
