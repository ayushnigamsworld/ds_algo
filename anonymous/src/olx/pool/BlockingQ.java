package olx.pool;

public interface BlockingQ<T> {

    void enqueue(T t);
    T dequeue();
}
