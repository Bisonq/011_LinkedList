import list.List;
import list.doubleLinks.DoubleList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new DoubleList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(5);
        list.addLast(12);
        list.addLast(-4);

        Integer[] tab = new Integer[list.size()];
        tab = list.toArray(tab);
        System.out.println(Arrays.toString(tab));
        System.out.println(list);
    }
}
