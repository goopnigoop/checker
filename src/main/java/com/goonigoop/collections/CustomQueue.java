package com.goonigoop.collections;

public interface CustomQueue {
    int size();
    int currentSize();
    boolean add(int number);
    boolean addFirst(int number);
    boolean isFull();
    int poll();
    int pollLast();
    int showFirst();
    int showLast();
}
