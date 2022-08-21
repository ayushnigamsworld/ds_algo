package olx.pool;

public interface ThreadPickerI {

    Thread getFreeThread();
    void changeState(Thread currentThread, Thread.State state);
}
