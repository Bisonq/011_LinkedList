package list;

public interface List<E extends Comparable<E>> {

    /**
     * Add element to top of list
     * @param element element to be added, cannot be null
     * if element is null then IllegalArgumentException will be throw
     */
    void addFirst(E element);

    /**
     * Add element to the end of list
     * @param element element to be added, cannot be null
     * if element is null then IllegalArgumentException will be throw
     */
    void addLast(E element);

    /**
     * Remove element to top of list
     * @return true - if element has been removed
     * otherwise false, if element has not been removed
     * for example: when List is empty
     */
    boolean removeFirst();

    /**
     * Remove element to the end of list
     * @return true - if element has been removed
     * otherwise false, if element has not been removed
     * for example: when List is empty
     */
    boolean removeLast();

    /**
     * Remove first element from the list that is equals to given
     * @param element, element by which we will compare
     * @return true - if element has been removed
     * otherwise false, if element has not been removed
     * for example: when List is empty or the given element is not in the list
     */
    boolean remove(E element);

    /**
     * Return List size
     * @return number of elements in the list
     */
    int size();

    /**
     * Return minimal element in the list using Comparable tool
     * @return minimal element in the list
     */
    E getMin();

    /**
     * Return maximum element in the list using Comparable tool
     * @return maximal element in the list
     */
    E getMax();

    /**
     * Check if the list is empty
     * @return true, if the list is empty
     * otherwise false, when the list is not empty
     */
    boolean isEmpty();

    /**
     * Check if the list contain element
     * @param element value sought
     * @return true, if element is in the list
     * otherwise false, if element is not in the list
     */
    boolean contains(E element);

    /**
     * Clear the list
     */
    void clear();

    /**
     * Convert list into array
     * @param arr array that will store list elements
     * @return given empty array with added elements
     * or IllegalArgumentException when arr length is less than list length
     */
    E[] toArray(E[] arr);

    /**
     * Return the first encountered element
     * @param element value sought
     * @return value pointer or null when the element is not in the list
     */
    E get(E element);

    /**
     * Return first element in list
     * @return first element or null when list is empty
     */
    E getFirst();

    /**
     * Return las element in list
     * @return last element or null when list is empty
     */
    E getLast();
}