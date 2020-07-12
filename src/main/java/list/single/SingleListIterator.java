package list.single;

import java.util.Iterator;

public class SingleListIterator<E> implements Iterator<E> {

    private Node<E> node;

    SingleListIterator(Node<E> node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return this.node != null;
    }

    @Override
    public E next() {
        E pom = this.node.getElement();
        this.node = this.node.getNext();
        return pom;
    }
}
