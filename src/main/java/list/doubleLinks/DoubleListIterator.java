package list.doubleLinks;

import java.util.Iterator;

public class DoubleListIterator<E> implements Iterator<E> {

    private Node<E> head;
    private Node<E> tail;

    public DoubleListIterator(Node<E> head){
        this.head = head;
    }

    public DoubleListIterator(Node<E> head, Node<E> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean hasNext() {
        return this.head != null;
    }

    public boolean hasNPrev() {
        return this.tail != null;
    }

    @Override
    public E next() {
        E element = this.head.getElement();
        this.head = this.head.getNext();
        return element;
    }

    public E prev() {
        E element = this.tail.getElement();
        this.tail = this.tail.getPrev();
        return element;
    }
}
