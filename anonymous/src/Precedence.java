import java.util.*;

public class Precedence {

    public static void main(String[] args) {
        String input[] = {"P>E", "E>R", "R>U"};
        // "I>N","A>I","P>A","S>P"
        // I -> N  A -> I  P -> A  S -> P
        System.out.println((int)'A'); // 65
        System.out.println((int)'Z'); // 90

        int indegree[] = new int[26];
        List<Node> ll = new ArrayList<>();
        /*Set<Character> characterSet = new HashSet<>();
        for (int i=0; i< input.length; i++) {
            String current = input[0];
            char first = current.charAt(0);
            char op = current.charAt(1);
            char second = current.charAt(2);
            if (op == '>') {
                Node firstNode = new Node(first);
                Node secondNode = new Node(second);
                firstNode.next = secondNode;
                ll.add(firstNode);
                characterSet.add(second);
            } else {
                Node firstNode = new Node(second);
                Node secondNode = new Node(first);
                firstNode.next = secondNode;
                ll.add(firstNode);
                characterSet.add(first);
            }
        }*/

        //
        Map<Character, Character> characterMap = new HashMap<>();
        for (int i=0; i< input.length; i++) {
            String current = input[0];
            char first = current.charAt(0);
            char op = current.charAt(1);
            char second = current.charAt(2);
            if (op == '>') {
                characterMap.put(first, second);

            } else {
                characterMap.put(second, first);
            }
        }

        // head or starting point.
        char starting = 'P';
        int n = 4;
        while (n != 0) {
            Character nextC = characterMap.get(starting);
            System.out.print(nextC);
        }

        for (Map.Entry mapElement : characterMap.entrySet()) {
            Character key = (Character)mapElement.getKey();
            Character value = (Character)mapElement.getValue();

        }
    }

    static class Node {
        char c;
        Node next;
        Node(char c) {
            this.c = c;
        }
    }
}
