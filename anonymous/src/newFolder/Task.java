package newFolder;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  Inp of List
 *  Filter Stream
 *  reverse
 */
public class Task {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(50);
        list.add(7);
        list.add(4);
        list.add(80);
//        List<Integer> filtered = list.stream().filter(e -> e > 20).collect(Collectors.toList());
//        Collections.reverse(filtered);
        List<Integer> filtered2 = list.stream().filter(e -> e > 20).sorted( (a, b) -> b - a ).collect(Collectors.toList());
        System.out.println(filtered2);
    }
}
