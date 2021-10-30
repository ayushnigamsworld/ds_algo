package medium.backtracking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenerateParenthesis {

    static List<String> result = new ArrayList<>();
    static int counter = 0;
    public static void main(String[] args) {
        int n = 3;
        System.out.println(LocalDateTime.now());
        generateParethesis(n-1, n-1, new StringBuilder(), 0);
        System.out.println(LocalDateTime.now());
        System.out.println(counter);
        result = new ArrayList<>();
        counter = 0;
        System.out.println(LocalDateTime.now());
        backTrackGenerate(n-1, n-1, new StringBuilder(), 0);
        System.out.println(LocalDateTime.now());
        System.out.println(counter);
        System.out.println(result);
    }

    private static void generateParethesis(int left, int right, StringBuilder localResult, int total) {
        counter ++;
        if (left < 0 && right < 0 && total == 0) {
            result.add(localResult.toString());
            return;
        }
        if (left >= 0) {
            localResult.append("(");
            generateParethesis(left-1, right, localResult, total + 1);
        }
        if (right >= 0) {
            if (total > 0) {
                localResult.append(")");
                generateParethesis(left, right-1, localResult, total - 1);
            } else {
                return;
            }
        }
    }

    private static void backTrackGenerate(int left, int right, StringBuilder localResult, int total) {
        counter ++;
        if (left < 0 && right < 0) {
            result.add(localResult.toString());
            return;
        }

        if (left >= 0) {
            localResult.append("(");
            backTrackGenerate(left - 1, right, localResult, total + 1);
            localResult.deleteCharAt(localResult.length() - 1);
        }

        if (right >= 0 && total > 0) {
            localResult.append(")");
            backTrackGenerate(left, right - 1, localResult, total - 1);
            localResult.deleteCharAt(localResult.length() - 1);
        }
    }
}
