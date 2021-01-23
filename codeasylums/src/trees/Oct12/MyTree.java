package trees.Oct12;

public class MyTree<T> {
    public Node<T> root;
    MyTree() {

    }
    public MyTree(T data) {
        root = new Node<T>(data);
    }
}
