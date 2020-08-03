package BST.selfBalancingBST;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SelfBalancing {

    public static void main(String[] args) {
        TreeSet<Integer> selfBalanceBST = new TreeSet<>();
        selfBalanceBST.add(3);
        selfBalanceBST.add(7);
        selfBalanceBST.add(-10);
        selfBalanceBST.add(2);
        selfBalanceBST.add(6);
        performBasicOp(selfBalanceBST);
        TreeMap<Integer, String> selfBalancing = new TreeMap<>();
        selfBalancing.put(3, "Hello");
        selfBalancing.put(8, "oh my god");
        selfBalancing.put(2, "yohoo");
        selfBalancing.put(9, "ollalala");
        selfBalancing.put(7, "hahaha");
        performBasicOp(selfBalancing);
    }

    private static void performBasicOp(TreeSet<Integer> ts) {
        ts.ceiling(2);
        ts.contains(7);
        ts.floor(1);
        ts.remove(-10);
        for (Integer a: ts) {
            System.out.println(a);
        }
    }

    private static void performBasicOp(TreeMap<Integer, String> treeMap) {
        Map.Entry<Integer, String> e = treeMap.ceilingEntry(4);
        System.out.println(e.getValue());
        treeMap.remove(8);
        treeMap.forEach((k, v) -> {
            System.out.println(k + " - " + v);
        });
    }
}
