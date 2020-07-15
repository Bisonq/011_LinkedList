package list.circularLinks;

import list.List;

import java.util.Iterator;

public class CircularList<E extends Comparable<E>> implements List<E> {

    private Node<E> head;
    private Node<E> tail;

    private E min;
    private E max;

    private int size;

    public CircularList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        if(size == 0){
            Node<E> node = new Node<>(element);;
            this.head = node;
            this.tail = node;
            this.head.setNext(tail);
            this.tail.setNext(head);
            this.head.setPrev(tail);
            this.tail.setPrev(head);
            this.min = element;
            this.max = element;
            this.size++;
        }else if(size == 1){
            this.tail = new Node<>(element);
            this.tail.setNext(head);
            this.tail.setPrev(head);
            size++;
            shareForMinMax(this.head);
        }else{
            Node<E> node = new Node<>(element);
            node.setNext(head);
            node.setPrev(tail);
            this.head = node;
            this.tail.setNext(this.head);
            size++;
            shareForMinMax(this.head);
        }
    }

    @Override
    public void addLast(E element) {

    }

    private void shareForMinMax(Node<E> node){
        int counter = 0;
        while(counter++ < this.size){
            compareWithMax(node.getElement());
            compareWithMin(node.getElement());
            node = node.getNext();
        }
    }

    private void compareWithMin(E element){
        if(element.compareTo(min) < 0)
            this.min = element;
    }

    private void compareWithMax(E element){
        if(element.compareTo(max) > 0)
            this.max = element;
    }

    @Override
    public boolean removeFirst() {
        return false;
    }

    @Override
    public boolean removeLast() {
        return false;
    }

    @Override
    public boolean remove(E element) {
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E getMin() {
        return this.min;
    }

    @Override
    public E getMax() {
        return this.max;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean contains(E element) {
        if(this.isEmpty())
            return false;

        if(this.size == 1) {
            return this.head.getElement().compareTo(element) == 0;
        }

        Node<E> node = this.head;
        int counter = 0;
        while (counter++ < this.size){
            if(node.getElement().compareTo(element) == 0)
                return true;
            node = node.getNext();
        }
        return false;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.max = null;
        this.min = null;
        this.size = 0;
    }

    @Override
    public E[] toArray(E[] arr) {
        if (arr.length < this.size())
            throw new IllegalArgumentException("Array is to small");
        Node<E> node = this.head;
        int i = 0;
        while (i < this.size) {
            arr[i++] = node.getElement();
            node = node.getNext();
        }
        return arr;
    }

    @Override
    public E get(E element) {
        if (this.isEmpty())
            return null;
        Node<E> node = this.head;
        int counter = 0;
        while (counter++ < this.size) {
            if (node.getElement().compareTo(element) == 0)
                return node.getElement();
            node = node.getNext();
        }
        return null;
    }

    @Override
    public E getFirst() {
        return this.head.getElement();
    }

    @Override
    public E getLast() {
        return this.tail.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new CircularListIterator<>(this.head);
    }

    public CircularListIterator<E> reverseIterator() {
        return new CircularListIterator<>(this.head, this.tail);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> node = this.head;
        for(int i = 0 ; i < this.size ; i++){
            stringBuilder.append(node.getElement()).append(" ");
            node = node.getNext();
        }
        if(stringBuilder.length() > 0)
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    public String toStringReverse() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> node = this.tail;
        for(int i = 0 ; i < this.size ; i++){
            stringBuilder.append(node.getElement()).append(" ");
            node = node.getPrev();
        }
        if(stringBuilder.length() > 0)
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }
}
