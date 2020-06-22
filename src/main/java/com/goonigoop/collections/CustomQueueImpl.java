package com.goonigoop.collections;

public class CustomQueueImpl implements CustomQueue {

    private final int[] arr;
    private int head;
    private int tail;
    private boolean isEmpty;
    private int currentSize;

    public CustomQueueImpl(int size) {
        this.arr = new int[size];
        isEmpty = true;
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public int currentSize() {
        return currentSize;
    }

    @Override
    public boolean add(int number) {
        if (isFull()) {
            return false;
        }
        arr[tail] = number;
        tail = (tail + 1) % arr.length;
        isEmpty = false;
        currentSize++;
        return true;
    }

    @Override
    public boolean addFirst(int number) {
        if (isFull()) {
            return false;
        }
        for (int i = tail; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = number;
        tail = (tail + 1) % arr.length;
        isEmpty = false;
        currentSize++;
        return true;
    }

    @Override
    public boolean isFull() {
        return tail == head && !isEmpty;
    }

    @Override
    public int poll() {
        if (isEmpty) {
            return -1;
        }
        int result = arr[head];
        head = (head + 1) % arr.length;
        isEmpty = (tail == head);
        currentSize--;
        return result;
    }

    @Override
    public int pollLast() {
        //TODO add implementation
        return 0;
    }

    @Override
    public int showFirst() {
        return arr[head];
    }

    @Override
    public int showLast() {
        return arr[(tail - 1 + arr.length) % arr.length];
    }
}
