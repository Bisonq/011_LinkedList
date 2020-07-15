package list.circularLinks;

import java.util.Iterator;

public class CircularListIterator<E> implements Iterator<E> {

    private Node<E> head;
    private Node<E> tail;

    public CircularListIterator(Node<E> head) {
        this.head = head;
    }

    public CircularListIterator(Node<E> head, Node<E> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    public boolean hasPrev() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }

    public E prev() {
        return null;
    }
}
