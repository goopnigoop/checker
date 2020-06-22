package com.goonigoop.collections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.Objects.isNull;

public class CustomStackImpl implements CustomStack<String> {

    private final List<String> arr;
    private final Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    AtomicInteger counter;
    private final int SIZE;

    public CustomStackImpl(int size) {
        SIZE = size;
        arr = new CopyOnWriteArrayList<>();
        counter = new AtomicInteger(0);
    }

    @Override
    public int size() {
        return counter.get();
    }

    @Override
    public void push(String element) {
        if (isNull(element)) {
            throw new IllegalArgumentException("Element is null");
        }
        if (arr.size() == size()) {
            throw new IllegalArgumentException("The stack is full");
        }
        lock.lock();
        try {
            while (arr.size()>=SIZE) {
                condition.wait();
            }
            arr.set(counter.getAndIncrement(), element);
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println("Exception");
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String pop() {
        lock.lock();
        String result = null;
        try {
            while (arr.size()==0) {
                condition.wait();
            }
            result = arr.get(counter.decrementAndGet());
            arr.set(counter.get(), null);
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println("Exception");
        } finally {
            lock.unlock();
        }
        return result;
    }

    @Override
    public String peek() {
        return arr.get(counter.get() - 1);
    }

    @Override
    public boolean empty() {
        return counter.get() > 0;
    }

    @Override
    public void clear() {
        counter.set(0);
        arr.clear();
    }
}
