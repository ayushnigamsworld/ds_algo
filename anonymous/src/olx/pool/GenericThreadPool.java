package olx.pool;

public interface GenericThreadPool<T> {

    T createPool(int noOfThreads);

    void execute();
}
