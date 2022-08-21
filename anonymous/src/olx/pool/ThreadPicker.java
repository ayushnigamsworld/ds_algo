package olx.pool;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ThreadPicker implements ThreadPickerI {

    private Map<Thread.State, Set<Thread>> threadMap;
    // State --> List<Thread>
    private Queue<Thread> freeThreadStorage;

    public synchronized Thread getFreeThread() {
        // while free
        // wait();
        Thread t = freeThreadStorage.poll();
        notify();
        return t;
    }

    public void changeState(Thread currentThread, Thread.State state) {
        // manipulates threadMap
        // either pushing into the queue.
    }
}
