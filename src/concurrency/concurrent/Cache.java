package concurrency.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {

    private static final Cache INSTANCE = new Cache(); // "Singleton"

    private final Map<String, String> data = new HashMap<>();

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private Cache() {}

    public static Cache getInstance() {
        return INSTANCE;
    }

    public String get(String property) {
        lock.readLock().lock();
        try {
            return data.get(property);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void set(String property, String value) {
        lock.writeLock().lock();
        try {
            data.put(property, value);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
