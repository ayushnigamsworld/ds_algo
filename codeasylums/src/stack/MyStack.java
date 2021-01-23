package stack;

public class MyStack {

    private Integer[] storage = null;
    private Integer size = 0;
    private Integer top = -1;
    private Integer capacity = 0;
    public MyStack(Integer capacity) {
        storage = new Integer[capacity];
        this.capacity = capacity;
    }

    void push(Integer a) {
        if (size == this.capacity) {
            throw new Error("Overflow");
        }
        top++;
        storage[top] = a;
        size++;
    }

    Integer pop() {
        if (size == 0) {
            throw new Error("UnderFlow");
        }
        Integer toRemove = storage[top];
        top--;
        size--;
        return toRemove;
    }

    Integer peek() {
        if (size == 0) {
            return null;
        }
        return storage[top];
    }
}
