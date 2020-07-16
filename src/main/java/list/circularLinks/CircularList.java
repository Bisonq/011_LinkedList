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
            initializeList(element);
        }else if(size == 1){
            this.head = new Node<>(element);
            this.head.setNext(tail);
            this.head.setPrev(tail);
            this.tail.setNext(head);
            this.tail.setPrev(head);
            size++;
            shareForMinMax(this.head);
        }else{
            Node<E> node = new Node<>(element);
            node.setNext(head);
            node.setPrev(tail);
            this.head.setPrev(node);
            this.head = node;
            this.tail.setNext(this.head);
            size++;
            shareForMinMax(this.head);
        }
    }

    private void initializeList(E element) {
        Node<E> node = new Node<>(element);
        this.head = node;
        this.tail = node;
        this.head.setNext(tail);
        this.tail.setNext(head);
        this.head.setPrev(tail);
        this.tail.setPrev(head);
        this.min = element;
        this.max = element;
        this.size++;
    }

    @Override
    public void addLast(E element) {
        if(size == 0 ){
            initializeList(element);
        }else if(size == 1){
            this.tail = new Node<>(element);
            this.tail.setNext(head);
            this.tail.setPrev(head);
            this.head.setNext(tail);
            this.head.setPrev(tail);
            size++;
            shareForMinMax(this.head);
        }else{
            Node<E> node = new Node<>(element);
            node.setNext(this.head);
            node.setPrev(this.tail);
            this.tail.setNext(node);
            this.tail = node;
            this.head.setPrev(this.tail);
            size++;
            shareForMinMax(this.head);
        }
    }

    private void shareForMinMax(Node<E> node){
        int counter = 0;
        this.min = this.head.getElement();
        this.max = this.head.getElement();
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
        if(this.isEmpty())
            return false;
        if(this.size == 1){
            clear();
            return true;
        }else{
            this.head = this.head.getNext();
            this.head.setPrev(tail);
            this.tail.setNext(head);
            size--;
            shareForMinMax(this.head);
            return true;
        }
    }

    @Override
    public boolean removeLast() {
        if(this.isEmpty())
            return false;
        if(this.size == 1){
            clear();
            return true;
        }else{
            this.tail = this.tail.getPrev();
            this.tail.setNext(head);
            this.head.setPrev(tail);
            size--;
            shareForMinMax(this.head);
            return true;
        }
    }

    @Override
    public boolean remove(E element) {
        if(this.isEmpty())
            return false;
        if(this.size == 0){
            clear();
            return true;
        }else{
            if(this.head.getElement().compareTo(element) == 0)
                return this.removeFirst();

            int counter = 0;
            Node<E> node = this.head.getNext();
            while(counter++ < this.size){
                if(node.getElement().compareTo(element) == 0){
                    Node<E> next = node.getNext();
                    Node<E> prev = node.getPrev();
                    prev.setNext(next);
                    next.setPrev(prev);
                    shareForMinMax(this.head);
                    size--;
                    return true;
                }
                node = node.getNext();
            }
            return false;
        }
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
