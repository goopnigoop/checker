package com.goonigoop.collections;

public class CustomLinkedListImpl<T> implements CustomLinkedList<T> {
    private int size;
    private Node<T> head;

    public CustomLinkedListImpl() {
        this.size = 0;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> currentHead = this.head;
            while (currentHead.next != null) {
                currentHead = currentHead.next;
            }
            currentHead.next = newNode;
        }
        size++;
    }

    @Override
    public void addAtIndex(T element, int index) {
        if (index >= size) {
            throw new IllegalArgumentException("Index is too high");
        }
        Node<T> current = new Node<>(element);
        if (index == 0) {
            current.next = head;
            head = current;
        }

        int currentIndex = 0;
        Node<T> currentNode = head;
        while (currentIndex < index-1) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        Node<T> nextOld = currentNode.next;
        currentNode.next = current;
        current.next = nextOld;
        size++;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("Index is too high");
        }
        Node<T> currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Index can not ne applied, it's out of range");
        }
        Node<T> currentNode = this.head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = head.next;
        }
        Node<T> before = currentNode;
        Node<T> toDelete = currentNode.next;
        before.next = toDelete.next;
        toDelete.next = null;
        T result = toDelete.value;
        toDelete.value = null;
        size--;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean contains(T element) {
        Node<T> currentHead = this.head;
        do {
            if (currentHead.value.equals(element)) {
                return true;
            }
            currentHead = currentHead.next;
        }while (currentHead!=null);
        return false;
    }


    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + "}";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List: ");
        Node<T> currentHead = this.head;
        do {
            sb.append(currentHead);
            currentHead = currentHead.next;
        } while (currentHead != null);
        return sb.toString();
    }

}
