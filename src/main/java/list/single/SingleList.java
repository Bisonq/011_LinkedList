package list.single;

import list.List;

public class SingleList<E extends Comparable<E>> implements List<E> {

    private Node<E> head;
    private E min;
    private E max;

    public SingleList() {
        this.head = null;
    }

    @Override
    public void addFirst(E element) {
        if (element == null)
            throw new IllegalArgumentException("Element cannot be null");
        if (head == null) {
            this.head = new Node<>(element);
            this.head.setNext(null);
            this.min = element;
            this.max = element;
        } else {
            Node<E> node = new Node<>(element);
            node.setNext(this.head);
            this.head = node;
            compareElementToMinMax(element);
        }
    }

    @Override
    public void addLast(E element) {
        if (element == null)
            throw new IllegalArgumentException("Element cannot be null");
        if (head == null) {
            this.head = new Node<>(element);
            this.head.setNext(null);
            this.min = element;
            this.max = element;
        } else {
            Node<E> node = this.head;
            while (node.getNext() != null)
                node = node.getNext();
            Node<E> newlyNode = new Node<>(element);
            newlyNode.setNext(null);
            node.setNext(newlyNode);
            compareElementToMinMax(element);
        }
    }

    @Override
    public boolean removeFirst() {
        if (this.isEmpty())
            return false;
        else if (this.size() == 1) {
            this.head = null;
            this.max = null;
            this.min = null;
            return true;
        } else {
            boolean shareNewMinMax = false;
            if (this.head.getElement().compareTo(this.min) == 0) {
                this.min = null;
                shareNewMinMax = true;
            } else if (this.head.getElement().compareTo(this.max) == 0) {
                this.max = null;
                shareNewMinMax = true;
            }
            this.head = this.head.getNext();
            if (shareNewMinMax)
                shareMinMax();
            return true;
        }
    }

    @Override
    public boolean removeLast() {
        if (this.isEmpty())
            return false;
        else if (this.size() == 1) {
            this.head = null;
            return true;
        } else {
            boolean shareNewMinMax = false;
            Node<E> node = this.head.getNext();
            while (node.getNext().getNext() != null)
                node = node.getNext();
            if (node.getNext().getElement().compareTo(min) == 0) {
                this.min = null;
                shareNewMinMax = true;
            } else if (node.getNext().getElement().compareTo(max) == 0) {
                this.max = null;
                shareNewMinMax = true;
            }
            node.setNext(null);
            if (shareNewMinMax)
                shareMinMax();
            return true;
        }
    }

    @Override
    public boolean remove(E element) {
        if (this.isEmpty())
            return false;
        else if (this.size() == 1) {
            if (this.head.getElement().compareTo(element) == 0) {
                this.head = null;
                this.min = null;
                this.max = null;
                return true;
            } else
                return false;
        } else {
            if (this.head.getElement().compareTo(element) == 0) {
                this.head = this.head.getNext();
                if (element.compareTo(min) == 0)
                    min = null;
                else if (element.compareTo(max) == 0)
                    max = null;
                shareMinMax();
                return true;
            } else {
                Node<E> previous = this.head;
                Node<E> actual = this.head.getNext();
                while (actual != null) {
                    if (actual.getElement().compareTo(element) == 0) {
                        previous.setNext(actual.getNext());
                        if (element.compareTo(min) == 0)
                            min = null;
                        else if (element.compareTo(max) == 0)
                            max = null;
                        shareMinMax();
                        return true;
                    }
                    actual = actual.getNext();
                }
                return false;
            }
        }
    }

    @Override
    public int size() {
        int size = 0;
        Node<E> node = this.head;
        while (node != null) {
            size++;
            node = node.getNext();
        }
        return size;
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
        this.min = null;
        this.max = null;
    }

    @Override
    public E[] toArray() {
        return null;
    }

    protected void compareElementToMinMax(E element) {
        if (max == null || element.compareTo(max) > 0)
            this.max = element;
        if (min == null || element.compareTo(min) < 0)
            this.min = element;
    }

    protected void shareMinMax() {
        Node<E> node = this.head;
        while (node != null) {
            compareElementToMinMax(node.getElement());
            node = node.getNext();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> node = this.head;
        while (node != null) {
            stringBuilder.append(node.getElement()).append(" ");
            node = node.getNext();
        }
        if (stringBuilder.length() > 0)
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}