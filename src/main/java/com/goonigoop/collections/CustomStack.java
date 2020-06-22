package com.goonigoop.collections;

public interface CustomStack<E> {
    int size();
    void push(E element);
    E pop();
    E peek();
    boolean empty();
    void clear();
}
