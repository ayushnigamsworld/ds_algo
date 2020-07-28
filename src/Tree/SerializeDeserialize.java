package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Not able to do.
 */
public class SerializeDeserialize {

    public static void main(String[] args) {
        /**
         *          1
         *       2     3
         *     4   5
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        List<Integer> ll = serialize(root, new ArrayList<Integer>());
        for (int a: ll) {
            System.out.println(a);
        }
        deserialize(ll);
    }

    private static List<Integer> serialize(Node root, List<Integer> l) {
        if (root == null) {
            l.add(-1);
            return l;
        }
        l.add(root.data);
        serialize(root.left, l);
        serialize(root.right, l);
        return l;
    }

    private static int cnt = 0;
    private static Node deserialize(List<Integer> list) {
        int t = list.get(cnt);
        cnt++;
        if (t == -1) {
            return null;
        }
        if (cnt == list.size()) {
            return null;
        }
        Node temp = new Node(t);
        temp.left = deserialize(list);
        temp.right = deserialize(list);
        return temp;
    }
}
