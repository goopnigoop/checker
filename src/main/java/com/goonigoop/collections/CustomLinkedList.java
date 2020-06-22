package com.goonigoop.collections;

public interface CustomLinkedList<T> {
    void add(T element);
    void addAtIndex(T element, int index);
    T get(int index);
    T remove(int index);
    boolean isEmpty();
    int getCurrentSize();
    boolean contains(T element);
}
