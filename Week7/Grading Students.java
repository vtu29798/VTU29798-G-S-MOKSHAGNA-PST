import java.util.*;

public class Result {

    public static List<Integer> gradingStudents(List<Integer> grades) {

        List<Integer> result = new ArrayList<>();

        for (int grade : grades) {

            if (grade < 38) {
                result.add(grade);
            } else {

                int next = ((grade / 5) + 1) * 5;

                if (next - grade < 3) {
                    result.add(next);
                } else {
                    result.add(grade);
                }
            }
        }

        return result;
    }
}
