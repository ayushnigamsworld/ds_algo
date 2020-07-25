package Stack;

public class TwoStacks {
    int arr[] = new int[30];
    int top1 = -1;
    int top2 = arr.length;

    public void push1(int a) {
        if (!isFull()) {
            top1++;
            arr[top1] = a;
        }
    }

    public void push2(int a) {
        if (!isFull()) {
            top2--;
            arr[top2] = a;
        }
    }

    public void pop1() {
        if (!isEmpty()) {
            top1++;
        }
    }

    public void pop2() {
        if (!isEmpty()) {
            top2++;
        }
    }

    private boolean isFull() {
        if (top1 +1 > top2) {
            return true;
        }
        return false;
    }

    private boolean isEmpty() {
        if (top1 < 0 || top2 >= arr.length) {
            return true;
        }
        return false;
    }

}
