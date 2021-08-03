package remoteinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rvvse {

    public static void main(String[] args) {
        List<Long> m = new ArrayList<>();
        String input = "AbradCadABDDraA;akAzam";
        Set<Character> set = new HashSet<>();
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'a');
        System.out.println((int)'z');
        String result = "";
        for (int i=0; i<input.length(); i++) {
            char current = input.charAt(i);
            char otherCurrent = ' ';
            if (current >= 65 && current <= 90) {
                otherCurrent = (char)(current + 32);
            } else {
                otherCurrent = (char)(current - 32);
            }
            if (set.contains(current) || set.contains(otherCurrent)) {

            } else {
                set.add(current);
                set.add(otherCurrent);
                result += current;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.reverse();
        }
        System.out.println(result);

    }
}
