package list.doubleLinks;

import list.List;

import java.util.Iterator;

public class DoubleList<E extends Comparable<E>> implements List<E> {

    private Node<E> head;
    private Node<E> tail;

    private E min;
    private E max;

    public DoubleList(){
        this.head = null;
        this.tail = null;
    }

    @Override
    public void addFirst(E element) {
        if(element == null)
            throw new IllegalArgumentException("Element cannot be null");
        if (this.head == null){
            startUpList(element);
        }else{
            if(size() == 1){
                Node<E> node = new Node<>(element);
                node.setPrev(null);
                node.setNext(this.tail);
                this.head = node;
                this.tail.setPrev(this.head);
                shareForMinMax(this.head);
            }else{
                Node<E> node = new Node<>(element);
                node.setNext(this.head);
                node.setPrev(null);
                this.head.setPrev(node);
                this.head = node;
                shareForMinMax(this.head);
            }
        }
    }

    @Override
    public void addLast(E element) {
        if(element == null)
            throw new IllegalArgumentException("Element cannot be null");
        if(this.tail == null){
            startUpList(element);
        }else{
            if(size() == 1){
                Node<E> node = new Node<>(element);
                node.setNext(null);
                node.setPrev(this.head);
                this.tail = node;
                this.head.setNext(this.tail);
                shareForMinMax(this.head);
            }else{
                Node<E> node = new Node<>(element);
                node.setNext(null);
                node.setPrev(this.tail);
                this.tail.setNext(node);
                this.tail = node;
                shareForMinMax(this.head);
            }
        }
    }

    private void startUpList(E element) {
        Node<E> node = new Node<>(element);
        this.head = node;
        this.tail = node;
        this.head.setPrev(null);
        this.head.setNext(null);
        this.tail.setNext(null);
        this.tail.setPrev(null);
        this.min = element;
        this.max = element;
    }

    private void shareForMinMax(Node<E> node){
        while(node != null){
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
        Node<E> node = this.head;
        int counter = 0;
        while(node != null){
            node = node.getNext();
            counter++;
        }
        return counter;
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
        Node<E> node = this.head;
        while (node != null) {
            if (node.getElement().compareTo(element) == 0)
                return true;
            node = node.getNext();
        }
        return false;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.min = null;
        this.max = null;
    }

    @Override
    public E[] toArray(E[] arr) {
        if (arr.length < this.size())
            throw new IllegalArgumentException("Array is to small");
        Node<E> node = this.head;
        int i = 0;
        while (node != null) {
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
        while (node != null) {
            if (node.getElement().compareTo(element) == 0)
                return node.getElement();
            node = node.getNext();
        }
        return null;
    }

    @Override
    public E getFirst() {
        if(this.isEmpty())
            return null;
        return this.head.getElement();
    }

    @Override
    public E getLast() {
        if(this.isEmpty())
            return null;
        return this.tail.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> node = this.head;
        for(int i = 0 ; i < size() ; i++) {
            stringBuilder.append(node.getElement()).append(" ");
            node = node.getNext();
        }
        if(stringBuilder.length() > 0)
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

//    public String toString(){
//        StringBuilder stringBuilder = new StringBuilder();
//        Node<E> node = this.tail;
//        for(int i = 0 ; i < size() ; i++) {
//            stringBuilder.append(node.getElement()).append(" ");
//            node = node.getPrev();
//        }
//        if(stringBuilder.length() > 0)
//            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//        return stringBuilder.toString();
//    }
}
