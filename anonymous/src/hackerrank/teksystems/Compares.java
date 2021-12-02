package hackerrank.teksystems;

import java.util.Arrays;
import java.util.Comparator;

public class Compares {

    public static void main(String[] args) {
        String[] cities = {"Bang", "Pune", "San F", "New York"};
        Arrays.sort(cities, Comparator.reverseOrder());
        System.out.println(Arrays.binarySearch(cities, "Bang"));
    }
}
